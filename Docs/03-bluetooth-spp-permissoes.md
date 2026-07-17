# ToCar - Bluetooth clássico, BLE e permissões

## Permissoes no Manifest

```xml
<uses-permission android:name="android.permission.BLUETOOTH" android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

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

O controle do RS-2751BR PLUS foi confirmado em hardware via BLE/GATT. O serviço é `FFF0` e a característica bidirecional é `FFF1`. O Bluetooth clássico continua responsável pelo áudio A2DP e deve estar conectado antes da tentativa do canal de controle.

## Nomes esperados do radio

- `CAR-BT`
- `RS-2751BR`
- `RS-2751BR PLUS`
- `RS-2751BR PLUS-APP`
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
    val bonded: Boolean,
    val transport: BluetoothTransport
) {
    val isLikelyRoadstar: Boolean
        get() = ROADSTAR_NAMES.any { name.contains(it, ignoreCase = true) }
}
```

## Fluxo operacional atual

1. O usuário conecta `RS-2751BR PLUS` nas configurações Bluetooth do Android.
2. Abre o ToCar e concede localização/dispositivos próximos.
3. O app lista os dispositivos pareados; não conecta automaticamente.
4. O usuário escolhe o rádio e toca em **Conectar**.
5. A tela mostra **Tentando conectar** enquanto procura `RS-2751BR PLUS-APP`.
6. O controlador valida o endereço BLE, encerra a varredura e aguarda 1.200 ms.
7. Abre GATT em `TRANSPORT_LE`, descobre `FFF0/FFF1` e habilita notificações locais.
8. Se a abertura falhar com status 62, repete até 3 vezes, aguardando 1.800 ms entre tentativas.
9. O descritor CCCD `2902` é opcional porque o firmware testado não o expõe.
10. Envia `01 03` após 1.500 ms para sincronizar o estado.
11. Só então a interface muda para **Conectado**.

**Atualizar lista** apenas recarrega os pareados quando não há conexão ou tentativa ativa. A ação não deve chamar `disconnect()` nem iniciar GATT.

## Endereços observados no equipamento de teste

| Canal | Nome | Endereço |
|---|---|---|
| Bluetooth clássico/A2DP | `RS-2751BR PLUS` | `41:42:93:88:36:D5` |
| BLE de controle | `RS-2751BR PLUS-APP` | `41:42:93:88:36:80` |

No MIUI 14, alguns resultados de varredura apresentaram `00:00:00:00:00:00`. A descoberta Bluetooth do sistema registra posteriormente o endereço LE real. O mapeamento acima é específico do rádio testado; endereços BLE podem variar em outro equipamento.

## Cuidados

- Encerrar a varredura e aguardar antes de abrir GATT; conexão imediata produziu status 62.
- A reconexao deve ser controlada por estado.
- Não exigir descritor `2902` quando `setCharacteristicNotification()` tiver sido aceito.
- Não marcar `Connected` antes da descoberta de serviço e inicialização.
- O app deve suportar perda de conexao quando o carro for desligado.
- O Foreground Service de voz ja existe, mas a conexao Bluetooth de longa duracao ainda deve ser refinada depois de confirmar o protocolo real.
