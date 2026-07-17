package com.example.tocar.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothA2dp
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlin.coroutines.resume

class AndroidBluetoothController(
    context: Context,
    private val scope: CoroutineScope
) : RadioController {
    private val appContext = context.applicationContext
    private val adapter: BluetoothAdapter? =
        (appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

    private val _devices = MutableStateFlow<List<BluetoothDeviceInfo>>(emptyList())
    override val devices: StateFlow<List<BluetoothDeviceInfo>> = _devices.asStateFlow()

    private val _connectionState =
        MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    override val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()
    private val _signalStrength = MutableStateFlow<Int?>(null)
    override val signalStrength: StateFlow<Int?> = _signalStrength.asStateFlow()

    private var connection: SppConnection? = null
    private var bleConnection: BleGattConnection? = null
    private var readJob: Job? = null
    private var connectJob: Job? = null
    private val discoveredDevices = mutableMapOf<String, BluetoothDevice>()
    private val loggedAdvertisementAddresses = mutableSetOf<String>()
    private var scanCallback: ScanCallback? = null

    override fun hasRequiredPermissions(): Boolean = requiredPermissions().all {
        ContextCompat.checkSelfPermission(appContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun requiredPermissions(): Array<String> {
        val permissions = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions += Manifest.permission.BLUETOOTH_CONNECT
            permissions += Manifest.permission.BLUETOOTH_SCAN
            permissions += Manifest.permission.ACCESS_FINE_LOCATION
            permissions += Manifest.permission.ACCESS_COARSE_LOCATION
        } else {
            permissions += Manifest.permission.BLUETOOTH
            permissions += Manifest.permission.BLUETOOTH_ADMIN
            permissions += Manifest.permission.ACCESS_FINE_LOCATION
        }
        return permissions.toTypedArray()
    }

    @SuppressLint("MissingPermission")
    override fun refreshBondedDevices() {
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
            discoveredDevices[device.address] = device
            BluetoothDeviceInfo(
                name = device.name ?: "Sem nome",
                address = device.address,
                bonded = device.bondState == BluetoothDevice.BOND_BONDED,
                transport = BluetoothTransport.Classic
            )
        }.sortedWith(compareByDescending<BluetoothDeviceInfo> { it.isLikelyRoadstar }.thenBy { it.name })

        _devices.value = bonded
        if (_connectionState.value !is BluetoothConnectionState.Connected &&
            _connectionState.value !is BluetoothConnectionState.Connecting
        ) {
            _connectionState.value = BluetoothConnectionState.Disconnected
        }
    }

    @SuppressLint("MissingPermission")
    override fun connect(deviceInfo: BluetoothDeviceInfo, onPacket: suspend (ByteArray) -> Unit) {
        val bluetoothAdapter = adapter
        if (bluetoothAdapter == null) {
            _connectionState.value = BluetoothConnectionState.Unsupported
            return
        }
        if (!hasRequiredPermissions()) {
            _connectionState.value = BluetoothConnectionState.PermissionRequired
            return
        }

        if (_connectionState.value is BluetoothConnectionState.Connecting ||
            _connectionState.value is BluetoothConnectionState.Connected
        ) return

        _connectionState.value = BluetoothConnectionState.Connecting(deviceInfo)
        connectJob = scope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    stopBleScan()
                    bluetoothAdapter.cancelDiscovery()
                    val device = discoveredDevices[deviceInfo.address]
                        ?: bluetoothAdapter.getRemoteDevice(deviceInfo.address)

                    if (deviceInfo.transport == BluetoothTransport.Classic && deviceInfo.isLikelyRoadstar) {
                        check(isClassicAudioConnected(device)) {
                            "Conecte primeiro o RS-2751BR PLUS no Bluetooth do Android (audio/A2DP)"
                        }
                        Log.i("ToCarBLE", "classicReady name=${device.name} address=${device.address}")
                        val bleDevice = findRoadstarBleDevice(device)
                            ?: error("Canal APP nao foi anunciado pelo radio durante o scan BLE")
                        // Let MIUI finish stopping the LE scan before opening GATT.
                        // Connecting in the same scheduler tick commonly returns HCI 0x3E.
                        delay(SCAN_TO_CONNECT_DELAY_MS)
                        connectBle(bleDevice, onPacket)
                    } else {
                        val socket = device.createRfcommSocketToServiceRecord(SPP_UUID)
                        socket.connect()
                        SppConnection(socket)
                    }
                }
            }.onSuccess { activeConnection ->
                _connectionState.value = BluetoothConnectionState.Connected(deviceInfo)
                when (activeConnection) {
                    is SppConnection -> {
                        connection = activeConnection
                        readJob?.cancel()
                        readJob = scope.launch {
                            runCatching { activeConnection.readLoop(onPacket) }
                                .onFailure { _connectionState.value = BluetoothConnectionState.Error(it.message ?: "Falha lendo SPP") }
                        }
                    }
                    is BleGattConnection -> {
                        bleConnection = activeConnection
                    }
                }
            }.onFailure {
                _connectionState.value = BluetoothConnectionState.Error(it.message ?: "Falha ao conectar")
            }
        }
    }

    override suspend fun write(packet: ByteArray) {
        bleConnection?.write(packet) ?: connection?.write(packet) ?: error("Bluetooth desconectado")
    }

    override fun disconnect() {
        _signalStrength.value = null
        stopBleScan()
        connectJob?.cancel()
        connectJob = null
        readJob?.cancel()
        readJob = null
        connection?.close()
        connection = null
        bleConnection?.close()
        bleConnection = null
        _connectionState.value = BluetoothConnectionState.Disconnected
    }

    @SuppressLint("MissingPermission")
    private fun stopBleScan() {
        val callback = scanCallback ?: return
        runCatching { adapter?.bluetoothLeScanner?.stopScan(callback) }
        scanCallback = null
    }

    @SuppressLint("MissingPermission")
    private suspend fun findRoadstarBleDevice(classicDevice: BluetoothDevice): BluetoothDevice? {
        val scanner = adapter?.bluetoothLeScanner ?: return null
        val found = CompletableDeferred<BluetoothDevice?>()
        var maskedAppSeen = false
        var systemDiscoveryStarted = false
        val callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val device = result.device ?: return
                val name = result.scanRecord?.deviceName ?: device.name.orEmpty()
                discoveredDevices[device.address] = device
                if (!isAppControlName(name)) return
                if (device.address == MASKED_BLE_ADDRESS) {
                    maskedAppSeen = true
                    Log.e("ToCarBLE", "maskedControl name=$name address=${device.address}")
                    // MIUI can hide the address from ScanResult until the platform discovery
                    // has inserted the real LE peer in its inquiry database. CarLive performs
                    // this discovery before its successful GATT connection as well.
                    if (!systemDiscoveryStarted) {
                        systemDiscoveryStarted = adapter?.startDiscovery() == true
                        Log.i("ToCarBLE", "systemDiscovery started=$systemDiscoveryStarted")
                    }
                    return
                }
                Log.i("ToCarBLE", "validatedControl name=$name address=${device.address} legacy=${legacySignature(result)}")
                if (!found.isCompleted) found.complete(device)
            }

            override fun onScanFailed(errorCode: Int) {
                Log.e("ToCarBLE", "controlScanFailed code=$errorCode")
                if (!found.isCompleted) found.complete(null)
            }
        }

        stopBleScan()
        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()
        scanner.startScan(null, settings, callback)
        return try {
            withTimeout(15_000) { found.await() }
        } catch (_: TimeoutCancellationException) {
            if (maskedAppSeen) {
                val mappedAddress = KNOWN_CONTROL_ADDRESSES[classicDevice.address.uppercase()]
                if (mappedAddress != null) {
                    Log.w(
                        "ToCarBLE",
                        "maskedControlFallback classic=${classicDevice.address} ble=$mappedAddress source=verified_hci"
                    )
                    return adapter?.getRemoteDevice(mappedAddress)
                }
                error("Canal APP anunciado com endereco BLE zerado e sem mapeamento validado")
            }
            null
        } finally {
            runCatching { scanner.stopScan(callback) }
            if (systemDiscoveryStarted) runCatching { adapter?.cancelDiscovery() }
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun isClassicAudioConnected(device: BluetoothDevice): Boolean =
        try {
            withTimeout(5_000) {
                suspendCancellableCoroutine { continuation ->
                    var proxy: BluetoothProfile? = null
                    fun finish(connected: Boolean) {
                        proxy?.let { adapter?.closeProfileProxy(BluetoothProfile.A2DP, it) }
                        if (continuation.isActive) continuation.resume(connected)
                    }
                    val listener = object : BluetoothProfile.ServiceListener {
                        override fun onServiceConnected(profile: Int, service: BluetoothProfile) {
                            proxy = service
                            val connected = (service as BluetoothA2dp).connectedDevices
                                .any { it.address.equals(device.address, ignoreCase = true) }
                            finish(connected)
                        }

                        override fun onServiceDisconnected(profile: Int) = finish(false)
                    }
                    if (adapter?.getProfileProxy(appContext, listener, BluetoothProfile.A2DP) != true) {
                        finish(false)
                    }
                    continuation.invokeOnCancellation {
                        proxy?.let { adapter?.closeProfileProxy(BluetoothProfile.A2DP, it) }
                    }
                }
            }
        } catch (_: TimeoutCancellationException) {
            false
        }

    private suspend fun connectBle(
        device: BluetoothDevice,
        onPacket: suspend (ByteArray) -> Unit
    ): BleGattConnection {
        var lastError: Throwable? = null
        repeat(BLE_CONNECT_ATTEMPTS) { index ->
            val attempt = index + 1
            Log.i(
                "ToCarBLE",
                "connectAttempt attempt=$attempt/$BLE_CONNECT_ATTEMPTS address=${device.address} auto=false transport=${BluetoothDevice.TRANSPORT_LE}"
            )
            val ble = BleGattConnection(
                context = appContext,
                device = device,
                scope = scope,
                onPacket = onPacket,
                onRssi = { _signalStrength.value = it },
                autoConnect = false,
                transport = BluetoothDevice.TRANSPORT_LE
            )
            try {
                ble.connect()
                return ble
            } catch (error: Throwable) {
                lastError = error
                Log.e("ToCarBLE", "connectFailure attempt=$attempt address=${device.address} message=${error.message}")
                ble.close()
                val transientStatus62 = error.message?.contains("BLE status 62") == true
                if (!transientStatus62 || attempt == BLE_CONNECT_ATTEMPTS) throw error
                delay(BLE_RETRY_DELAY_MS)
            }
        }
        throw lastError ?: IllegalStateException("Falha BLE desconhecida")
    }

    private fun legacySignature(result: ScanResult): String = result.scanRecord?.bytes
        ?.joinToString("") { "%02X".format(it.toInt() and 0xFF) }
        ?.drop(10)
        ?.take(12)
        .orEmpty()

    private fun isAppControlName(name: String): Boolean =
        name.contains("PLUS-APP", ignoreCase = true) ||
            name.contains("CAR KIT-APP", ignoreCase = true) ||
            (name.contains("RS-2751", ignoreCase = true) && name.contains("APP", ignoreCase = true))

    private companion object {
        const val MASKED_BLE_ADDRESS = "00:00:00:00:00:00"
        const val SCAN_TO_CONNECT_DELAY_MS = 1_200L
        const val BLE_RETRY_DELAY_MS = 1_800L
        const val BLE_CONNECT_ATTEMPTS = 3
        val KNOWN_CONTROL_ADDRESSES = mapOf(
            "41:42:93:88:36:D5" to "41:42:93:88:36:80"
        )
    }
}
