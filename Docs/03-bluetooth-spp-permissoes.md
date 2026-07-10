# ToCar - Bluetooth SPP e permissoes

## Permissoes no Manifest

```xml
<uses-permission android:name="android.permission.BLUETOOTH" android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" android:maxSdkVersion="30" />

<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />

<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_MICROPHONE" />
```

## UUID SPP

```kotlin
val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
```

## UUIDs encontrados no APK CarLive

```kotlin
val CARLIVE_BLE_SERVICE_UUID = UUID.fromString("0000FFF0-0000-1000-8000-00805F9B34FB")
val CARLIVE_BLE_NOTICE_UUID = UUID.fromString("0000FFF1-0000-1000-8000-00805F9B34FB")
val CARLIVE_EXTRA_UUID = UUID.fromString("258EAFA5-E914-47DA-95CA-C5AB0DC85B11")
```

Esses UUIDs indicam que o CarLive tambem usa BLE em algum fluxo. O ToCar ainda prioriza SPP porque o roadmap inicial e o comportamento esperado do radio citam Bluetooth classico/serial.

## Nomes esperados do radio

- `CAR-BT`
- `RS-2751BR`
- `CAR KIT-APP`
- `CAR KIT`

## Estado da conexao

```kotlin
sealed interface BluetoothConnectionState {
    data object Unsupported : BluetoothConnectionState
    data object PermissionRequired : BluetoothConnectionState
    data object Disconnected : BluetoothConnectionState
    data object Scanning : BluetoothConnectionState
    data class Connecting(val device: BluetoothDeviceInfo) : BluetoothConnectionState
    data class Connected(val device: BluetoothDeviceInfo) : BluetoothConnectionState
    data class Error(val message: String) : BluetoothConnectionState
}
```

## Modelo de dispositivo

```kotlin
data class BluetoothDeviceInfo(
    val name: String,
    val address: String,
    val bonded: Boolean
) {
    val isLikelyRoadstar: Boolean
        get() = ROADSTAR_NAMES.any { name.contains(it, ignoreCase = true) }
}
```

## Fluxo atual

1. O app pede permissoes.
2. Lista dispositivos ja pareados.
3. Destaca nomes compativeis com Roadstar.
4. Conecta via RFCOMM/SPP.
5. Le RX em loop.
6. Escreve TX somente quando `CommandEncoder` retornar bytes.

## Cuidados

- Depois de conectar, cancelar discovery.
- A reconexao deve ser controlada por estado.
- O app deve suportar perda de conexao quando o carro for desligado.
- O Foreground Service de voz ja existe, mas a conexao Bluetooth de longa duracao ainda deve ser refinada depois de confirmar o protocolo real.

