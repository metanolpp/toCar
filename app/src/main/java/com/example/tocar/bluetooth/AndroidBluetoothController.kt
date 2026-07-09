package com.example.tocar.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AndroidBluetoothController(
    context: Context,
    private val scope: CoroutineScope
) {
    private val appContext = context.applicationContext
    private val adapter: BluetoothAdapter? =
        (appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

    private val _devices = MutableStateFlow<List<BluetoothDeviceInfo>>(emptyList())
    val devices: StateFlow<List<BluetoothDeviceInfo>> = _devices.asStateFlow()

    private val _connectionState =
        MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()

    private var connection: SppConnection? = null
    private var readJob: Job? = null

    fun hasRequiredPermissions(): Boolean = requiredPermissions().all {
        ContextCompat.checkSelfPermission(appContext, it) == PackageManager.PERMISSION_GRANTED
    }

    fun requiredPermissions(): Array<String> {
        val permissions = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions += Manifest.permission.BLUETOOTH_CONNECT
            permissions += Manifest.permission.BLUETOOTH_SCAN
        } else {
            permissions += Manifest.permission.BLUETOOTH
            permissions += Manifest.permission.BLUETOOTH_ADMIN
            permissions += Manifest.permission.ACCESS_FINE_LOCATION
        }
        permissions += Manifest.permission.RECORD_AUDIO
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions += Manifest.permission.POST_NOTIFICATIONS
        }
        return permissions.toTypedArray()
    }

    @SuppressLint("MissingPermission")
    fun refreshBondedDevices() {
        val bluetoothAdapter = adapter
        if (bluetoothAdapter == null) {
            _connectionState.value = BluetoothConnectionState.Unsupported
            return
        }
        if (!hasRequiredPermissions()) {
            _connectionState.value = BluetoothConnectionState.PermissionRequired
            return
        }

        val bonded = bluetoothAdapter.bondedDevices.orEmpty().map { device ->
            BluetoothDeviceInfo(
                name = device.name ?: "Sem nome",
                address = device.address,
                bonded = device.bondState == android.bluetooth.BluetoothDevice.BOND_BONDED
            )
        }.sortedWith(compareByDescending<BluetoothDeviceInfo> { it.isLikelyRoadstar }.thenBy { it.name })

        _devices.value = bonded
        _connectionState.value = BluetoothConnectionState.Disconnected
    }

    @SuppressLint("MissingPermission")
    fun connect(deviceInfo: BluetoothDeviceInfo, onPacket: suspend (ByteArray) -> Unit) {
        val bluetoothAdapter = adapter
        if (bluetoothAdapter == null) {
            _connectionState.value = BluetoothConnectionState.Unsupported
            return
        }
        if (!hasRequiredPermissions()) {
            _connectionState.value = BluetoothConnectionState.PermissionRequired
            return
        }

        scope.launch {
            _connectionState.value = BluetoothConnectionState.Connecting(deviceInfo)
            runCatching {
                withContext(Dispatchers.IO) {
                    bluetoothAdapter.cancelDiscovery()
                    val device = bluetoothAdapter.getRemoteDevice(deviceInfo.address)
                    val socket = device.openSppSocket()
                    socket.connect()
                    SppConnection(socket)
                }
            }.onSuccess { spp ->
                connection = spp
                _connectionState.value = BluetoothConnectionState.Connected(deviceInfo)
                readJob?.cancel()
                readJob = scope.launch {
                    runCatching { spp.readLoop(onPacket) }
                        .onFailure { _connectionState.value = BluetoothConnectionState.Error(it.message ?: "Falha lendo SPP") }
                }
            }.onFailure {
                _connectionState.value = BluetoothConnectionState.Error(it.message ?: "Falha ao conectar")
            }
        }
    }

    suspend fun write(packet: ByteArray) {
        val activeConnection = connection ?: error("Bluetooth SPP desconectado")
        activeConnection.write(packet)
    }

    fun disconnect() {
        readJob?.cancel()
        readJob = null
        connection?.close()
        connection = null
        _connectionState.value = BluetoothConnectionState.Disconnected
    }
}
