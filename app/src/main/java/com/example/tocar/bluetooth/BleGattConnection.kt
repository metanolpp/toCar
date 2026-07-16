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
import android.util.Log
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
            Log.i(TAG, "connection address=${device.address} status=$status state=$newState")
            if (status != BluetoothGatt.GATT_SUCCESS) {
                ready.completeExceptionally(IllegalStateException("BLE status $status"))
                return
            }

            when (newState) {
                BluetoothProfile.STATE_CONNECTED -> {
                    val started = gatt.discoverServices()
                    Log.i(TAG, "discoverServices address=${device.address} started=$started")
                    if (!started) ready.completeExceptionally(IllegalStateException("Falha iniciando descoberta GATT"))
                }
                BluetoothProfile.STATE_DISCONNECTED -> {
                    if (!ready.isCompleted) {
                        ready.completeExceptionally(IllegalStateException("BLE desconectado"))
                    }
                }
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            Log.i(TAG, "services address=${device.address} status=$status count=${gatt.services.size}")
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
            if (!gatt.setCharacteristicNotification(characteristic, true)) {
                ready.completeExceptionally(IllegalStateException("Falha habilitando notificacao FFF1"))
                return
            }
            val descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID)
            if (descriptor == null) {
                // This Roadstar firmware exposes FFF1 without a CCCD. CarLive only
                // registers the local notification callback and continues writing.
                Log.i(TAG, "descriptor2902 absent address=${device.address}; continuing like CarLive")
                ready.complete(Unit)
                return
            }
            val accepted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                gatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == BluetoothGatt.GATT_SUCCESS
            } else {
                @Suppress("DEPRECATION")
                descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                @Suppress("DEPRECATION")
                gatt.writeDescriptor(descriptor)
            }
            Log.i(TAG, "enableNotifications address=${device.address} accepted=$accepted")
            if (!accepted) ready.completeExceptionally(IllegalStateException("Falha escrevendo descriptor 2902"))
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            Log.i(TAG, "descriptorWrite address=${device.address} uuid=${descriptor.uuid} status=$status")
            if (descriptor.uuid != CLIENT_CHARACTERISTIC_CONFIG_UUID) return
            if (status == BluetoothGatt.GATT_SUCCESS) ready.complete(Unit)
            else ready.completeExceptionally(IllegalStateException("Falha confirmando notificacoes: $status"))
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
        kotlinx.coroutines.delay(SYNCHRONIZE_DELAY_MS)
        write(SYNCHRONIZE_PACKET)
        Log.i(TAG, "synchronize address=${device.address} packet=0103")
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
        const val TAG = "ToCarBLE"
        const val CONNECT_TIMEOUT_MS = 18_000L
        const val SYNCHRONIZE_DELAY_MS = 1_500L
        val SYNCHRONIZE_PACKET = byteArrayOf(0x01, 0x03)
    }
}
