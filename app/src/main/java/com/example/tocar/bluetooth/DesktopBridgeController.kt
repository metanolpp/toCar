package com.example.tocar.bluetooth

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.tocar.protocol.parseHexPacket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket

class DesktopBridgeController(
    context: Context,
    private val scope: CoroutineScope,
    private val host: String = EMULATOR_HOST,
    private val port: Int = BRIDGE_PORT
) : RadioController {
    private val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
    private val _devices = MutableStateFlow<List<BluetoothDeviceInfo>>(emptyList())
    override val devices: StateFlow<List<BluetoothDeviceInfo>> = _devices.asStateFlow()

    private val _connectionState = MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    override val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()
    private val _signalStrength = MutableStateFlow<Int?>(null)
    override val signalStrength: StateFlow<Int?> = _signalStrength.asStateFlow()

    private var socket: Socket? = null
    private var writer: PrintWriter? = null
    private var readerJob: Job? = null
    private var onPacket: (suspend (ByteArray) -> Unit)? = null
    private var pendingDevice: BluetoothDeviceInfo? = null

    override fun hasRequiredPermissions(): Boolean = true
    override fun requiredPermissions(): Array<String> = emptyArray()

    override fun refreshBondedDevices() {
        _devices.value = emptyList()
        _connectionState.value = BluetoothConnectionState.Scanning
        scope.launch {
            runCatching {
                ensureSocket()
                sendLine("SCAN")
            }.onFailure { error ->
                _connectionState.value = BluetoothConnectionState.Error("Bridge $host:$port: ${error.message}")
            }
        }
    }

    override fun connect(deviceInfo: BluetoothDeviceInfo, onPacket: suspend (ByteArray) -> Unit) {
        this.onPacket = onPacket
        pendingDevice = deviceInfo
        _connectionState.value = BluetoothConnectionState.Connecting(deviceInfo)
        scope.launch {
            runCatching {
                ensureSocket()
                sendLine("CONNECT|${deviceInfo.address}")
            }.onFailure { error ->
                _connectionState.value = BluetoothConnectionState.Error("Bridge: ${error.message}")
            }
        }
    }

    override suspend fun write(packet: ByteArray) {
        check(_connectionState.value is BluetoothConnectionState.Connected) { "Bridge desconectado" }
        sendLine("WRITE|${packet.joinToString("") { "%02X".format(it.toInt() and 0xFF) }}")
    }

    override fun disconnect() {
        _signalStrength.value = null
        runCatching { writer?.println("DISCONNECT") }
        readerJob?.cancel()
        readerJob = null
        runCatching { socket?.close() }
        socket = null
        writer = null
        onPacket = null
        pendingDevice = null
        _connectionState.value = BluetoothConnectionState.Disconnected
    }

    private suspend fun ensureSocket() = withContext(Dispatchers.IO) {
        if (socket?.isConnected == true && socket?.isClosed == false) return@withContext
        val ethernetNetwork = connectivityManager.allNetworks.firstOrNull { network ->
            connectivityManager.getNetworkCapabilities(network)
                ?.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) == true
        }
        val active = (ethernetNetwork?.socketFactory?.createSocket() ?: Socket()).apply {
            connect(
                InetSocketAddress(
                    this@DesktopBridgeController.host,
                    this@DesktopBridgeController.port
                ),
                CONNECT_TIMEOUT_MS
            )
        }
        socket = active
        writer = PrintWriter(active.getOutputStream(), true)
        readerJob = scope.launch(Dispatchers.IO) { readLoop(active) }
        sendLine("HELLO|TOCAR_ANDROID|1")
    }

    private suspend fun readLoop(active: Socket) {
        val reader = BufferedReader(InputStreamReader(active.getInputStream()))
        runCatching {
            while (true) handleLine(reader.readLine() ?: break)
        }.onFailure { error ->
            if (socket === active) _connectionState.value = BluetoothConnectionState.Error("Bridge RX: ${error.message}")
        }.also {
            if (socket === active) {
                runCatching { active.close() }
                socket = null
                writer = null
            }
        }
    }

    private suspend fun handleLine(line: String) {
        val parts = line.split('|')
        when (parts.firstOrNull()) {
            "DEVICE" -> if (parts.size >= 3) {
                val info = BluetoothDeviceInfo(parts[1], parts[2], false, BluetoothTransport.Ble)
                _devices.value = (_devices.value.filterNot { it.address == info.address } + info).sortedBy { it.name }
            }
            "SCAN_DONE" -> if (_connectionState.value == BluetoothConnectionState.Scanning) {
                _connectionState.value = BluetoothConnectionState.Disconnected
            }
            "CONNECTED" -> {
                val device = pendingDevice ?: _devices.value.firstOrNull()
                if (device != null) _connectionState.value = BluetoothConnectionState.Connected(device)
            }
            "DISCONNECTED" -> _connectionState.value = BluetoothConnectionState.Disconnected
            "RX" -> parts.getOrNull(1)?.let { hex -> parseHexPacket(hex).getOrNull()?.let { onPacket?.invoke(it) } }
            "ERROR" -> _connectionState.value = BluetoothConnectionState.Error(parts.drop(1).joinToString(" | "))
        }
    }

    private suspend fun sendLine(line: String) = withContext(Dispatchers.IO) {
        val activeWriter = writer ?: error("Bridge sem socket")
        activeWriter.println(line)
        check(!activeWriter.checkError()) { "Falha escrevendo no bridge" }
    }

    private companion object {
        const val EMULATOR_HOST = "10.0.2.2"
        const val BRIDGE_PORT = 8765
        const val CONNECT_TIMEOUT_MS = 3_000
    }
}
