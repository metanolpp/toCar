package com.example.tocar.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.os.Build
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.util.UUID

private val CLIENT_CHARACTERISTIC_CONFIG_UUID: UUID =
    UUID.fromString("00002902-0000-1000-8000-00805F9B34FB")

@SuppressLint("MissingPermission")
class BleGattConnection(
    private val context: Context,
    private val device: BluetoothDevice,
    private val scope: CoroutineScope,
    private val onPacket: suspend (ByteArray) -> Unit,
    private val autoConnect: Boolean = false,
    private val transport: Int = BluetoothDevice.TRANSPORT_LE
) {
    private var gatt: BluetoothGatt? = null
    private var txCharacteristic: BluetoothGattCharacteristic? = null
    private val ready = CompletableDeferred<Unit>()

    private val callback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                ready.completeExceptionally(IllegalStateException("BLE status $status"))
                return
            }

            when (newState) {
                BluetoothProfile.STATE_CONNECTED -> gatt.discoverServices()
                BluetoothProfile.STATE_DISCONNECTED -> {
                    if (!ready.isCompleted) {
                        ready.completeExceptionally(IllegalStateException("BLE desconectado"))
                    }
                }
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                ready.completeExceptionally(IllegalStateException("Falha descobrindo servicos BLE: $status"))
                return
            }

            val characteristic = gatt
                .getService(CARLIVE_BLE_SERVICE_UUID)
                ?.getCharacteristic(CARLIVE_BLE_NOTICE_UUID)

            if (characteristic == null) {
                ready.completeExceptionally(IllegalStateException("Servico FFF0/FFF1 nao encontrado"))
                return
            }

            txCharacteristic = characteristic
            gatt.setCharacteristicNotification(characteristic, true)
            characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID)?.let { descriptor ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    gatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)
                } else {
                    @Suppress("DEPRECATION")
                    descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                    @Suppress("DEPRECATION")
                    gatt.writeDescriptor(descriptor)
                }
            }
            ready.complete(Unit)
        }

        @Deprecated("Deprecated in Java")
        override fun onCharacteristicChanged(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic
        ) {
            @Suppress("DEPRECATION")
            dispatchPacket(characteristic.value)
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray
        ) {
            dispatchPacket(value)
        }
    }

    suspend fun connect() = withContext(Dispatchers.IO) {
        val selectedTransport = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            transport
        } else {
            BluetoothDevice.TRANSPORT_AUTO
        }
        gatt = device.connectGatt(context, autoConnect, callback, selectedTransport)
        withTimeout(CONNECT_TIMEOUT_MS) { ready.await() }
    }

    suspend fun write(packet: ByteArray) = withContext(Dispatchers.IO) {
        val activeGatt = gatt ?: error("BLE desconectado")
        val characteristic = txCharacteristic ?: error("Characteristic FFF1 indisponivel")
        characteristic.writeType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT

        val accepted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            activeGatt.writeCharacteristic(
                characteristic,
                packet,
                BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
            ) == BluetoothGatt.GATT_SUCCESS
        } else {
            @Suppress("DEPRECATION")
            characteristic.value = packet
            @Suppress("DEPRECATION")
            activeGatt.writeCharacteristic(characteristic)
        }

        check(accepted) { "Falha ao enfileirar escrita BLE" }
    }

    fun close() {
        runCatching { gatt?.disconnect() }
        runCatching { gatt?.close() }
        gatt = null
        txCharacteristic = null
    }

    private fun dispatchPacket(value: ByteArray) {
        scope.launch(Dispatchers.IO) {
            onPacket(value)
        }
    }

    private companion object {
        const val CONNECT_TIMEOUT_MS = 18_000L
    }
}
