package com.example.tocar.bluetooth

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DemoRadioController(
    private val scope: CoroutineScope
) : RadioController {
    private val demoDevice = BluetoothDeviceInfo(
        name = "TOCAR DEMO // RS-2751BR",
        address = "DE:MO:FF:F0:FF:F1",
        bonded = true,
        transport = BluetoothTransport.Ble
    )

    private val _devices = MutableStateFlow<List<BluetoothDeviceInfo>>(emptyList())
    override val devices: StateFlow<List<BluetoothDeviceInfo>> = _devices.asStateFlow()

    private val _connectionState = MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    override val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()

    private var onPacket: (suspend (ByteArray) -> Unit)? = null

    override fun hasRequiredPermissions(): Boolean = true
    override fun requiredPermissions(): Array<String> = emptyArray()

    override fun refreshBondedDevices() {
        _connectionState.value = BluetoothConnectionState.Scanning
        scope.launch {
            delay(350)
            _devices.value = listOf(demoDevice)
            _connectionState.value = BluetoothConnectionState.Disconnected
        }
    }

    override fun connect(deviceInfo: BluetoothDeviceInfo, onPacket: suspend (ByteArray) -> Unit) {
        this.onPacket = onPacket
        _connectionState.value = BluetoothConnectionState.Connecting(deviceInfo)
        scope.launch {
            delay(450)
            _connectionState.value = BluetoothConnectionState.Connected(deviceInfo)
            onPacket(byteArrayOf(0x0F, 0x01, 0x44, 0x45, 0x4D, 0x4F))
            onPacket(byteArrayOf(0x08, 0x04))
            onPacket(byteArrayOf(0x0D, 0x01, 0x26, 0x48))
        }
    }

    override suspend fun write(packet: ByteArray) {
        check(_connectionState.value is BluetoothConnectionState.Connected) { "Demo desconectado" }
        delay(80)
        onPacket?.invoke(packet)
    }

    override fun disconnect() {
        onPacket = null
        _connectionState.value = BluetoothConnectionState.Disconnected
    }
}
