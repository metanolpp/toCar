package com.example.tocar.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

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
    private var bleConnection: BleGattConnection? = null
    private var readJob: Job? = null
    private val discoveredDevices = mutableMapOf<String, BluetoothDevice>()
    private var scanCallback: ScanCallback? = null

    fun hasRequiredPermissions(): Boolean = requiredPermissions().all {
        ContextCompat.checkSelfPermission(appContext, it) == PackageManager.PERMISSION_GRANTED
    }

    fun requiredPermissions(): Array<String> {
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
            discoveredDevices[device.address] = device
            BluetoothDeviceInfo(
                name = device.name ?: "Sem nome",
                address = device.address,
                bonded = device.bondState == BluetoothDevice.BOND_BONDED,
                transport = BluetoothTransport.Classic
            )
        }.sortedWith(compareByDescending<BluetoothDeviceInfo> { it.isLikelyRoadstar }.thenBy { it.name })

        _devices.value = bonded
        _connectionState.value = BluetoothConnectionState.Scanning
        startBleScan(bonded)
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
                    val device = discoveredDevices[deviceInfo.address]
                        ?: bluetoothAdapter.getRemoteDevice(deviceInfo.address)

                    if (deviceInfo.transport == BluetoothTransport.Ble || deviceInfo.isLikelyRoadstar) {
                        val bleDevices = if (deviceInfo.transport == BluetoothTransport.Ble) {
                            listOf(device)
                        } else {
                            findRoadstarBleDevices(deviceInfo)
                                .ifEmpty { error("Controle BLE nao encontrado. Toque em Atualizar e conecte no item BLE/APP.") }
                        }
                        connectBleWithRetries(bleDevices, onPacket)
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

    suspend fun write(packet: ByteArray) {
        bleConnection?.write(packet) ?: connection?.write(packet) ?: error("Bluetooth desconectado")
    }

    fun disconnect() {
        stopBleScan()
        readJob?.cancel()
        readJob = null
        connection?.close()
        connection = null
        bleConnection?.close()
        bleConnection = null
        _connectionState.value = BluetoothConnectionState.Disconnected
    }

    @SuppressLint("MissingPermission")
    private fun startBleScan(baseDevices: List<BluetoothDeviceInfo>) {
        val scanner = adapter?.bluetoothLeScanner ?: run {
            _connectionState.value = BluetoothConnectionState.Disconnected
            return
        }

        stopBleScan()
        val callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val device = result.device ?: return
                discoveredDevices[device.address] = device
                val name = result.scanRecord?.deviceName ?: device.name ?: "BLE sem nome"
                val info = BluetoothDeviceInfo(
                    name = name,
                    address = device.address,
                    bonded = device.bondState == BluetoothDevice.BOND_BONDED,
                    transport = BluetoothTransport.Ble
                )
                _devices.value = (_devices.value.filterNot { it.address == info.address } + info)
                    .sortedWith(compareByDescending<BluetoothDeviceInfo> { it.isLikelyRoadstar }.thenBy { it.name })
            }

            override fun onScanFailed(errorCode: Int) {
                _devices.value = baseDevices
                _connectionState.value = BluetoothConnectionState.Error("Falha no scan BLE: $errorCode")
            }
        }

        scanCallback = callback
        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()
        scanner.startScan(null, settings, callback)
        scope.launch {
            kotlinx.coroutines.delay(6_000)
            stopBleScan()
            if (_connectionState.value == BluetoothConnectionState.Scanning) {
                _connectionState.value = BluetoothConnectionState.Disconnected
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun stopBleScan() {
        val callback = scanCallback ?: return
        runCatching { adapter?.bluetoothLeScanner?.stopScan(callback) }
        scanCallback = null
    }

    @SuppressLint("MissingPermission")
    private suspend fun findRoadstarBleDevices(seed: BluetoothDeviceInfo): List<BluetoothDevice> {
        val cached = discoveredDevices.values.filter { device ->
            device.address != seed.address && isLikelyBleRoadstar(device.name, device.address, seed.address)
        }
        if (cached.isNotEmpty()) return cached

        val scanner = adapter?.bluetoothLeScanner ?: return directRoadstarBleCandidates(seed.address)
        val found = CompletableDeferred<List<BluetoothDevice>>()
        val scanMatches = linkedMapOf<String, BluetoothDevice>()
        val callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val device = result.device ?: return
                val name = result.scanRecord?.deviceName ?: device.name.orEmpty()
                discoveredDevices[device.address] = device
                if (isLikelyBleRoadstar(name, device.address, seed.address)) {
                    scanMatches[device.address] = device
                    if (!found.isCompleted) found.complete(scanMatches.values.toList())
                }
            }

            override fun onScanFailed(errorCode: Int) {
                if (!found.isCompleted) found.complete(emptyList())
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
            scanMatches.values.toList().ifEmpty { directRoadstarBleCandidates(seed.address) }
        } finally {
            runCatching { scanner.stopScan(callback) }
        }
    }

    @SuppressLint("MissingPermission")
    private fun directRoadstarBleCandidates(classicAddress: String): List<BluetoothDevice> {
        val bluetoothAdapter = adapter ?: return emptyList()
        val prefix = classicAddress.substringBeforeLast(":", missingDelimiterValue = "")
        if (prefix.isBlank()) return emptyList()

        val addresses = listOf(
            "$prefix:80",
            "41:42:93:88:36:80"
        ).distinct()

        return addresses.flatMap { address ->
            val devices = mutableListOf<BluetoothDevice>()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                runCatching {
                    bluetoothAdapter.getRemoteLeDevice(address, BluetoothDevice.ADDRESS_TYPE_RANDOM)
                }.getOrNull()?.let(devices::add)
                runCatching {
                    bluetoothAdapter.getRemoteLeDevice(address, BluetoothDevice.ADDRESS_TYPE_PUBLIC)
                }.getOrNull()?.let(devices::add)
            }
            runCatching {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bluetoothAdapter.getRemoteLeDevice(address, BluetoothDevice.ADDRESS_TYPE_UNKNOWN)
                } else {
                    bluetoothAdapter.getRemoteDevice(address)
                }
            }.getOrNull()?.let(devices::add)
            devices
        }.distinctBy { it.address + it.type }
    }

    private fun isLikelyBleRoadstar(name: String?, address: String, seedAddress: String): Boolean {
        val normalizedName = name.orEmpty()
        val samePrefix = address.substringBeforeLast(":", "") == seedAddress.substringBeforeLast(":", "")
        return normalizedName.contains("RS-2751", ignoreCase = true) ||
            normalizedName.contains("CAR KIT", ignoreCase = true) ||
            normalizedName.contains("APP", ignoreCase = true) ||
            samePrefix
    }

    private suspend fun connectBleWithRetries(
        devices: List<BluetoothDevice>,
        onPacket: suspend (ByteArray) -> Unit
    ): BleGattConnection {
        val attempts = listOf(
            BleAttempt(autoConnect = false, transport = BluetoothDevice.TRANSPORT_LE),
            BleAttempt(autoConnect = false, transport = BluetoothDevice.TRANSPORT_AUTO),
            BleAttempt(autoConnect = true, transport = BluetoothDevice.TRANSPORT_LE)
        )
        var lastError: Throwable? = null

        for (device in devices) {
            for (attempt in attempts) {
                val ble = BleGattConnection(
                    context = appContext,
                    device = device,
                    scope = scope,
                    onPacket = onPacket,
                    autoConnect = attempt.autoConnect,
                    transport = attempt.transport
                )
                try {
                    ble.connect()
                    return ble
                } catch (error: Throwable) {
                    lastError = error
                    ble.close()
                    kotlinx.coroutines.delay(900)
                }
            }
        }

        throw lastError ?: IllegalStateException("Falha BLE sem detalhe")
    }

    private data class BleAttempt(val autoConnect: Boolean, val transport: Int)
}
