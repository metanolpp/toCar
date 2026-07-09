# ToCar — Arquitetura Android

## Stack

- Kotlin
- Jetpack Compose
- Material Design 3
- Android 13 API 33+
- Bluetooth clássico SPP
- MVVM
- Coroutines + Flow

## Estrutura sugerida

```text
app/src/main/java/br/com/tocar/

├── MainActivity.kt
├── App.kt
│
├── navigation/
│   └── ToCarNavGraph.kt
│
├── ui/
│   ├── bluetooth/
│   │   ├── BluetoothScreen.kt
│   │   ├── BluetoothViewModel.kt
│   │   └── BluetoothUiState.kt
│   │
│   ├── controls/
│   │   ├── MainControlsScreen.kt
│   │   ├── MainControlsViewModel.kt
│   │   └── MainControlsUiState.kt
│   │
│   ├── files/
│   │   ├── FileBrowserScreen.kt
│   │   ├── FileBrowserViewModel.kt
│   │   └── FileBrowserUiState.kt
│   │
│   ├── audio/
│   │   ├── AudioSettingsScreen.kt
│   │   ├── AudioSettingsViewModel.kt
│   │   └── AudioSettingsUiState.kt
│   │
│   ├── developer/
│   │   ├── PacketLogScreen.kt
│   │   ├── PacketLogViewModel.kt
│   │   └── PacketLogUiState.kt
│   │
│   └── theme/
│
├── bluetooth/
│   ├── AndroidBluetoothController.kt
│   ├── BluetoothDeviceInfo.kt
│   ├── BluetoothConnectionState.kt
│   ├── SppClient.kt
│   ├── SppConnection.kt
│   └── SppConstants.kt
│
├── protocol/
│   ├── RadioCommand.kt
│   ├── RadioMode.kt
│   ├── EqPreset.kt
│   ├── RepeatMode.kt
│   ├── RadioState.kt
│   ├── CommandEncoder.kt
│   ├── ResponseDecoder.kt
│   ├── UnknownPacket.kt
│   └── ProtocolMap.kt
│
├── repository/
│   └── RadioRepository.kt
│
├── logging/
│   ├── PacketLog.kt
│   ├── PacketLogger.kt
│   └── HexFormatter.kt
│
└── voice/
    ├── VoiceCommandParser.kt
    └── VoiceCommand.kt
```

## Implementacao atual

A primeira versao do app usa o pacote `com.example.tocar` e separa:

- Frontend Compose em `ui/app`.
- Bluetooth em `bluetooth`.
- Protocolo em `protocol`.
- Repositorio em `repository`.
- Logs em `logging`.
- Voz em `voice`.

O APK CarLive 2.284 fornecido indica uso de `com.zddz.bt`, Bluetooth classico e BLE. Por isso o ToCar mantem SPP e tambem registra UUIDs BLE encontrados no APK para uma etapa futura:

```text
SPP:  00001101-0000-1000-8000-00805F9B34FB
BLE:  0000FFF0-0000-1000-8000-00805F9B34FB
BLE:  0000FFF1-0000-1000-8000-00805F9B34FB
Extra: 258EAFA5-E914-47DA-95CA-C5AB0DC85B11
```

Regra de seguranca: UUID de conexao nao equivale a bytes de comando. Os comandos continuam bloqueados no `CommandEncoder` ate captura ou decompilacao confirmada.

## Fluxo principal

```text
Compose Screen
   ↓
ViewModel
   ↓
RadioRepository
   ↓
CommandEncoder
   ↓
SppConnection.outputStream
   ↓
Rádio Roadstar
```

Fluxo de retorno:

```text
Rádio Roadstar
   ↓
SppConnection.inputStream
   ↓
ResponseDecoder
   ↓
RadioRepository
   ↓
StateFlow<RadioState>
   ↓
ViewModel
   ↓
Compose Screen
```

## Princípio mais importante
A interface nunca deve conhecer bytes Bluetooth diretamente.

Errado:

```kotlin
button.onClick { socket.outputStream.write(byteArrayOf(0x01, 0x02)) }
```

Certo:

```kotlin
button.onClick { viewModel.send(RadioCommand.Next) }
```

Assim, quando o pacote real for descoberto, somente o `CommandEncoder` muda.

## Estados globais

```kotlin
data class RadioState(
    val connected: Boolean = false,
    val mode: RadioMode? = null,
    val volume: Int? = null,
    val trackName: String? = null,
    val eqPreset: EqPreset? = null,
    val bass: Int = 0,
    val treble: Int = 0,
    val balance: Int = 0,
    val fader: Int = 0,
    val loudness: Boolean = false,
    val lastRxPacket: ByteArray? = null,
    val lastTxPacket: ByteArray? = null
)
```

## Repositório central

```kotlin
class RadioRepository(
    private val sppConnection: SppConnection,
    private val encoder: CommandEncoder,
    private val decoder: ResponseDecoder,
    private val logger: PacketLogger
) {
    val radioState: StateFlow<RadioState> = TODO()

    suspend fun send(command: RadioCommand) {
        val packet = encoder.encode(command)
        logger.tx(command, packet)
        sppConnection.write(packet)
    }

    suspend fun startReading() {
        sppConnection.readLoop { packet ->
            logger.rx(packet)
            val statePatch = decoder.decode(packet)
            // atualizar StateFlow
        }
    }
}
```
