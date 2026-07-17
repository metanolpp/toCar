package com.example.tocar.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.tocar.protocol.parseHexPacket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class DebugBleCommandReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != ACTION) return

        val pendingResult = goAsync()
        val command = intent.getStringExtra(EXTRA_COMMAND).orEmpty()
        val packet = commandPacket(command)

        if (packet == null) {
            Log.w(TAG, "Comando recusado: $command")
            pendingResult.finish()
            return
        }

        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
            runCatching {
                sendBleCommand(context.applicationContext, command, packet)
            }.onFailure { error ->
                Log.e(TAG, "Falha no teste BLE: ${error.message}", error)
            }
            pendingResult.finish()
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun sendBleCommand(context: Context, command: String, packet: ByteArray) {
        require(hasBluetoothPermissions(context)) { "Permissoes Bluetooth ausentes" }

        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val adapter = bluetoothManager.adapter ?: error("Bluetooth indisponivel")
        val scanner = adapter.bluetoothLeScanner ?: error("Scanner BLE indisponivel")
        var target: BluetoothDevice? = null

        val callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val name = result.scanRecord?.deviceName ?: result.device.name.orEmpty()
                if (name.contains("RS-2751", ignoreCase = true) || name.contains("APP", ignoreCase = true)) {
                    target = result.device
                    Log.i(TAG, "BLE encontrado: $name ${result.device.address}")
                    scanner.stopScan(this)
                }
            }
        }

        scanner.startScan(callback)
        withTimeout(8_000) {
            while (target == null) delay(150)
        }
        scanner.stopScan(callback)

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        val connection = BleGattConnection(
            context = context,
            device = target ?: error("BLE nao encontrado"),
            scope = scope,
            onPacket = { bytes: ByteArray ->
            Log.i(TAG, "RX ${bytes.joinToString(" ") { "%02X".format(it.toInt() and 0xFF) }}")
            },
            onRssi = { rssi -> Log.i(TAG, "RSSI $rssi dBm") }
        )
        try {
            connection.connect()
            connection.write(packet)
            Log.i(TAG, "TX $command ${packet.joinToString(" ") { "%02X".format(it.toInt() and 0xFF) }}")
            delay(1_000)
        } finally {
            connection.close()
        }
    }

    private fun hasBluetoothPermissions(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun commandPacket(command: String): ByteArray? = when (command.lowercase()) {
        "mode" -> byteArrayOf(0x01, 0x01)
        "next" -> byteArrayOf(0x03, 0x02, 0x00)
        "previous", "prev" -> byteArrayOf(0x03, 0x01, 0x00)
        else -> command
            .takeIf { it.startsWith("raw:", ignoreCase = true) }
            ?.removePrefix("raw:")
            ?.removePrefix("RAW:")
            ?.let { parseHexPacket(it, maxBytes = 8).getOrNull() }
    }

    companion object {
        const val ACTION = "com.example.tocar.DEBUG_BLE_COMMAND"
        private const val EXTRA_COMMAND = "command"
        private const val TAG = "ToCarBleTest"
    }
}
