package com.example.tocar.logging

import com.example.tocar.protocol.toHexString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class PacketDirection {
    TX,
    RX,
    APP,
    BLOCKED
}

data class PacketLogEntry(
    val time: String,
    val direction: PacketDirection,
    val label: String,
    val hex: String = "",
    val size: Int = 0
)

class PacketLogger {
    private val formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)
    private val _entries = MutableStateFlow<List<PacketLogEntry>>(emptyList())
    val entries: StateFlow<List<PacketLogEntry>> = _entries.asStateFlow()

    fun tx(label: String, bytes: ByteArray) {
        add(PacketDirection.TX, label, bytes.toHexString(), bytes.size)
    }

    fun rx(bytes: ByteArray) {
        add(PacketDirection.RX, "Pacote recebido", bytes.toHexString(), bytes.size)
    }

    fun app(label: String) {
        add(PacketDirection.APP, label)
    }

    fun blocked(label: String) {
        add(PacketDirection.BLOCKED, label)
    }

    private fun add(direction: PacketDirection, label: String, hex: String = "", size: Int = 0) {
        val entry = PacketLogEntry(
            time = formatter.format(Date()),
            direction = direction,
            label = label,
            hex = hex,
            size = size
        )
        _entries.update { current -> (listOf(entry) + current).take(150) }
    }
}

