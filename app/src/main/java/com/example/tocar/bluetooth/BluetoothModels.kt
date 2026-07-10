package com.example.tocar.bluetooth

import java.util.UUID

val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

// UUIDs found in the provided CarLive 2.284 APK. They look like a BLE UART-style
// service/characteristic pair and must be validated on the real Roadstar unit.
val CARLIVE_BLE_SERVICE_UUID: UUID = UUID.fromString("0000FFF0-0000-1000-8000-00805F9B34FB")
val CARLIVE_BLE_NOTICE_UUID: UUID = UUID.fromString("0000FFF1-0000-1000-8000-00805F9B34FB")
val CARLIVE_EXTRA_UUID: UUID = UUID.fromString("258EAFA5-E914-47DA-95CA-C5AB0DC85B11")

data class BluetoothDeviceInfo(
    val name: String,
    val address: String,
    val bonded: Boolean,
    val transport: BluetoothTransport = BluetoothTransport.Classic
) {
    val isLikelyRoadstar: Boolean
        get() = ROADSTAR_NAMES.any { name.contains(it, ignoreCase = true) }
}

enum class BluetoothTransport {
    Classic,
    Ble
}

sealed interface BluetoothConnectionState {
    data object Unsupported : BluetoothConnectionState
    data object PermissionRequired : BluetoothConnectionState
    data object Disconnected : BluetoothConnectionState
    data object Scanning : BluetoothConnectionState
    data class Connecting(val device: BluetoothDeviceInfo) : BluetoothConnectionState
    data class Connected(val device: BluetoothDeviceInfo) : BluetoothConnectionState
    data class Error(val message: String) : BluetoothConnectionState
}

private val ROADSTAR_NAMES = listOf("CAR-BT", "RS-2751", "CAR KIT", "CAR KIT-APP", "APP")
