package com.example.tocar.bluetooth

import kotlinx.coroutines.flow.StateFlow

interface RadioController {
    val devices: StateFlow<List<BluetoothDeviceInfo>>
    val connectionState: StateFlow<BluetoothConnectionState>

    fun hasRequiredPermissions(): Boolean
    fun requiredPermissions(): Array<String>
    fun refreshBondedDevices()
    fun connect(deviceInfo: BluetoothDeviceInfo, onPacket: suspend (ByteArray) -> Unit)
    suspend fun write(packet: ByteArray)
    fun disconnect()
}

enum class ControllerBackend(val label: String, val description: String) {
    AndroidBle("ANDROID BLE", "Bluetooth real do celular"),
    DesktopBridge("BRIDGE PC", "Bluetooth do notebook via 10.0.2.2:8765"),
    Demo("DEMO AVD", "Rádio virtual para testar a interface")
}
