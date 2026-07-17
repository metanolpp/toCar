# ToCar - Arquitetura Android

## Stack

- Kotlin.
- Jetpack Compose.
- Material Design 3.
- Coroutines + Flow.
- Bluetooth LE/GATT para controle do RS-2751BR PLUS.
- Bluetooth clássico A2DP mantido pelo Android para áudio; SPP permanece como fallback não confirmado.
- SpeechRecognizer e TextToSpeech.
- Foreground Service para voz em segundo plano.
- SharedPreferences para presets locais.

## Estrutura atual

```text
app/src/main/java/com/example/tocar/

├── MainActivity.kt
│
├── ui/
│   ├── app/
│   │   └── ToCarApp.kt
│   └── theme/
│
├── bluetooth/
│   ├── AndroidBluetoothController.kt
│   ├── BleGattConnection.kt
│   ├── BluetoothModels.kt
│   ├── RadioController.kt
│   ├── DesktopBridgeController.kt
│   ├── DemoRadioController.kt
│   └── SppConnection.kt
│
├── protocol/
│   ├── RadioCommand.kt
│   ├── RadioModels.kt
│   ├── ProtocolMap.kt
│   └── Hex.kt
│
├── repository/
│   └── RadioRepository.kt
│
├── logging/
│   └── PacketLog.kt
│
├── preset/
│   └── AudioPreset.kt
│
└── voice/
    ├── BackgroundVoiceService.kt
    ├── MusicSearch.kt
    └── VoiceCommandParser.kt
```

## Fluxo principal

```text
Compose UI ou BackgroundVoiceService
   ↓
RadioRepository
   ↓
CommandEncoder
   ↓
AndroidBluetoothController
   ↓
BleGattConnection / característica FFF1
   ↓
Radio Roadstar
```

Fluxo de retorno:

```text
Radio Roadstar
   ↓
Notificações GATT em FFF1
   ↓
RadioRepository.onRxPacket
   ↓
PacketLogger
   ↓
Tela Log
```

`RadioRepository` já interpreta respostas básicas de modo e frequência. A decodificação completa de metadados e ajustes continua incremental.

## Regra central

A UI nunca deve conhecer bytes Bluetooth diretamente.

Errado:

```kotlin
button.onClick { socket.outputStream.write(byteArrayOf(0x01, 0x02)) }
```

Certo:

```kotlin
button.onClick { repository.send(RadioCommand.NextTrack) }
```

Assim, quando o pacote real for descoberto, somente `CommandEncoder` e `ProtocolMap` precisam mudar.

## Estado global

```kotlin
data class RadioState(
    val connected: Boolean = false,
    val deviceName: String? = null,
    val mode: RadioMode? = null,
    val volume: Int = 18,
    val bass: Int = 0,
    val treble: Int = 0,
    val balance: Int = 0,
    val fader: Int = 0,
    val eqPreset: EqPreset = EqPreset.OFF,
    val loudness: Boolean = false,
    val panelColor: PanelColor = PanelColor.AUTO,
    val lastVoiceText: String? = null,
    val lastMessage: String = "Pronto para conectar ao Roadstar"
)
```

## Voz

Ha dois fluxos:

- Voz dentro do app via `RecognizerIntent`.
- Voz em segundo plano via `BackgroundVoiceService`.

Ambos usam:

- `VoiceCommandParser` para comandos diretos.
- `MusicSearchEngine` para busca de musica por nome.
- `PresetRepository` para aplicar presets por voz.
- `RadioRepository` para enviar comandos logicos.

## Presets

`PresetRepository` salva localmente:

- EQ.
- BAS.
- TRE.
- BAL.
- FAD.
- LOUD.
- Cor do painel.

Aplicar um preset gera uma lista de `RadioCommand`.

## CarLive

O APK CarLive 2.284 fornecido indica uso de `com.zddz.bt`, Bluetooth classico e BLE. UUIDs encontrados:

```text
SPP:  00001101-0000-1000-8000-00805F9B34FB
BLE:  0000FFF0-0000-1000-8000-00805F9B34FB
BLE:  0000FFF1-0000-1000-8000-00805F9B34FB
Extra: 258EAFA5-E914-47DA-95CA-C5AB0DC85B11
```

UUID de conexao nao equivale a bytes de comando. Os comandos continuam bloqueados no `CommandEncoder` ate captura ou decompilacao confirmada.
