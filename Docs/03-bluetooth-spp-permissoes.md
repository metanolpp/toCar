# ToCar — Bluetooth SPP e Permissões Android 13+

## Permissões no AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.BLUETOOTH" android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" android:maxSdkVersion="30" />

<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />

<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" android:maxSdkVersion="30" />
```

## UUID SPP

```kotlin
val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
```

## Nomes esperados do rádio
Pelo manual e pelo comportamento esperado:

- CAR-BT
- RS-2751BR
- CAR KIT-APP

## Estado da conexão

```kotlin
sealed interface BluetoothConnectionState {
    data object Disconnected : BluetoothConnectionState
    data object PermissionRequired : BluetoothConnectionState
    data object Scanning : BluetoothConnectionState
    data object Connecting : BluetoothConnectionState
    data class Connected(val name: String, val address: String) : BluetoothConnectionState
    data class Error(val message: String) : BluetoothConnectionState
}
```

## Modelo de dispositivo

```kotlin
data class BluetoothDeviceInfo(
    val name: String?,
    val address: String,
    val bonded: Boolean
) {
    val isLikelyRoadstar: Boolean
        get() = name?.contains("CAR-BT", ignoreCase = true) == true ||
                name?.contains("RS-2751", ignoreCase = true) == true ||
                name?.contains("CAR KIT", ignoreCase = true) == true
}
```

## Classe SppConnection

```kotlin
class SppConnection(
    private val socket: BluetoothSocket
) {
    private val input = socket.inputStream
    private val output = socket.outputStream

    suspend fun write(packet: ByteArray) = withContext(Dispatchers.IO) {
        output.write(packet)
        output.flush()
    }

    suspend fun readLoop(onPacket: suspend (ByteArray) -> Unit) = withContext(Dispatchers.IO) {
        val buffer = ByteArray(1024)

        while (socket.isConnected) {
            val read = input.read(buffer)
            if (read > 0) {
                onPacket(buffer.copyOf(read))
            }
        }
    }

    fun close() {
        runCatching { socket.close() }
    }
}
```

## Cliente SPP

```kotlin
@SuppressLint("MissingPermission")
class SppClient(
    private val bluetoothAdapter: BluetoothAdapter
) {
    suspend fun connect(device: BluetoothDevice): SppConnection = withContext(Dispatchers.IO) {
        bluetoothAdapter.cancelDiscovery()

        val socket = device.createRfcommSocketToServiceRecord(SPP_UUID)
        socket.connect()

        SppConnection(socket)
    }
}
```

## Cuidados

- O scan deve rodar fora da thread principal.
- Depois de conectar, cancelar discovery.
- A reconexão deve ser controlada por estado.
- O app deve suportar perda de conexão quando o carro for desligado.
- Para estabilidade, considerar Foreground Service na etapa final.
