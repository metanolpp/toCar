package com.example.tocar.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothSocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class SppConnection(
    private val socket: BluetoothSocket
) {
    suspend fun write(packet: ByteArray) = withContext(Dispatchers.IO) {
        socket.outputStream.write(packet)
        socket.outputStream.flush()
    }

    suspend fun readLoop(onPacket: suspend (ByteArray) -> Unit) = withContext(Dispatchers.IO) {
        val buffer = ByteArray(1024)
        while (socket.isConnected && coroutineContext.isActive) {
            val read = socket.inputStream.read(buffer)
            if (read > 0) onPacket(buffer.copyOf(read))
        }
    }

    fun close() {
        runCatching { socket.close() }
    }
}

@SuppressLint("MissingPermission")
fun android.bluetooth.BluetoothDevice.openSppSocket(): BluetoothSocket =
    createRfcommSocketToServiceRecord(SPP_UUID)

