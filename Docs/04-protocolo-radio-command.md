# ToCar — Protocolo, Comandos e Mapeamento

## Premissa
O manual mostra o que o rádio faz, mas não mostra os bytes enviados pelo CarLive. Por isso, este arquivo define os comandos funcionais e deixa os pacotes como `TODO` até a captura real.

## Comandos principais

```kotlin
sealed interface RadioCommand {
    data object PowerToggle : RadioCommand
    data object MuteToggle : RadioCommand

    data object ModeNext : RadioCommand
    data class SetMode(val mode: RadioMode) : RadioCommand

    data object PlayPause : RadioCommand
    data object NextTrack : RadioCommand
    data object PreviousTrack : RadioCommand
    data object NextStation : RadioCommand
    data object PreviousStation : RadioCommand
    data object IntroToggle : RadioCommand
    data object RepeatToggle : RadioCommand
    data object RandomToggle : RadioCommand

    data object SkipMinus10 : RadioCommand
    data object SkipPlus10 : RadioCommand
    data object DirectoryPrevious : RadioCommand
    data object DirectoryNext : RadioCommand

    data object VolumeUp : RadioCommand
    data object VolumeDown : RadioCommand
    data class SetVolume(val value: Int) : RadioCommand

    data object Band : RadioCommand
    data object Ams : RadioCommand
    data object Clock : RadioCommand

    data object CallAnswerOrRedial : RadioCommand
    data object CallEnd : RadioCommand

    data class SetEq(val preset: EqPreset) : RadioCommand
    data class SetBass(val value: Int) : RadioCommand
    data class SetTreble(val value: Int) : RadioCommand
    data class SetBalance(val value: Int) : RadioCommand
    data class SetFader(val value: Int) : RadioCommand
    data class SetLoudness(val enabled: Boolean) : RadioCommand
    data class SetPanelColor(val color: PanelColor) : RadioCommand

    data class SelectFolderTrack(val folder: Int, val track: Int) : RadioCommand
    data class Raw(val bytes: ByteArray) : RadioCommand
}
```

## Modos

```kotlin
enum class RadioMode {
    RADIO,
    USB,
    SD,
    AUX_IN,
    BT,
    COLOR
}
```

O manual informa a ordem física do botão MODE:

```text
RADIO → USB → SD → AUX IN → BT → COR
```

## EQ

```kotlin
enum class EqPreset {
    FLAT,
    ROCK,
    POP,
    CLASSIC,
    JAZZ,
    OFF
}
```

## Faixas de ajuste

```kotlin
object RadioRanges {
    const val BASS_MIN = -7
    const val BASS_MAX = 7

    const val TREBLE_MIN = -7
    const val TREBLE_MAX = 7

    const val BALANCE_MIN = -7
    const val BALANCE_MAX = 7

    const val FADER_MIN = -7
    const val FADER_MAX = 7
}
```

## Encoder inicial

```kotlin
class CommandEncoder(
    private val protocolMap: ProtocolMap
) {
    fun encode(command: RadioCommand): ByteArray {
        return when (command) {
            RadioCommand.PowerToggle -> protocolMap.powerToggle
            RadioCommand.MuteToggle -> protocolMap.muteToggle
            RadioCommand.ModeNext -> protocolMap.modeNext

            RadioCommand.PlayPause -> protocolMap.playPause
            RadioCommand.NextTrack -> protocolMap.nextTrack
            RadioCommand.PreviousTrack -> protocolMap.previousTrack
            RadioCommand.IntroToggle -> protocolMap.introToggle
            RadioCommand.RepeatToggle -> protocolMap.repeatToggle
            RadioCommand.RandomToggle -> protocolMap.randomToggle

            RadioCommand.SkipMinus10 -> protocolMap.skipMinus10
            RadioCommand.SkipPlus10 -> protocolMap.skipPlus10
            RadioCommand.DirectoryPrevious -> protocolMap.directoryPrevious
            RadioCommand.DirectoryNext -> protocolMap.directoryNext

            RadioCommand.VolumeUp -> protocolMap.volumeUp
            RadioCommand.VolumeDown -> protocolMap.volumeDown
            is RadioCommand.SetVolume -> encodeVolume(command.value)

            RadioCommand.Band -> protocolMap.band
            RadioCommand.Ams -> protocolMap.ams
            RadioCommand.Clock -> protocolMap.clock

            RadioCommand.CallAnswerOrRedial -> protocolMap.callAnswerOrRedial
            RadioCommand.CallEnd -> protocolMap.callEnd

            is RadioCommand.SetMode -> encodeMode(command.mode)
            is RadioCommand.SetEq -> encodeEq(command.preset)
            is RadioCommand.SetBass -> encodeSignedSetting("BAS", command.value)
            is RadioCommand.SetTreble -> encodeSignedSetting("TRE", command.value)
            is RadioCommand.SetBalance -> encodeSignedSetting("BAL", command.value)
            is RadioCommand.SetFader -> encodeSignedSetting("FAD", command.value)
            is RadioCommand.SetLoudness -> encodeLoudness(command.enabled)

            is RadioCommand.Raw -> command.bytes
        }
    }

    private fun encodeVolume(value: Int): ByteArray = TODO("Capturar pacote real")
    private fun encodeMode(mode: RadioMode): ByteArray = TODO("Capturar pacote real")
    private fun encodeEq(preset: EqPreset): ByteArray = TODO("Capturar pacote real")
    private fun encodeSignedSetting(type: String, value: Int): ByteArray = TODO("Capturar pacote real")
    private fun encodeLoudness(enabled: Boolean): ByteArray = TODO("Capturar pacote real")
}
```

## ProtocolMap provisório

```kotlin
data class ProtocolMap(
    val powerToggle: ByteArray = byteArrayOf(),
    val muteToggle: ByteArray = byteArrayOf(),
    val modeNext: ByteArray = byteArrayOf(),
    val playPause: ByteArray = byteArrayOf(),
    val nextTrack: ByteArray = byteArrayOf(),
    val previousTrack: ByteArray = byteArrayOf(),
    val introToggle: ByteArray = byteArrayOf(),
    val repeatToggle: ByteArray = byteArrayOf(),
    val randomToggle: ByteArray = byteArrayOf(),
    val skipMinus10: ByteArray = byteArrayOf(),
    val skipPlus10: ByteArray = byteArrayOf(),
    val directoryPrevious: ByteArray = byteArrayOf(),
    val directoryNext: ByteArray = byteArrayOf(),
    val volumeUp: ByteArray = byteArrayOf(),
    val volumeDown: ByteArray = byteArrayOf(),
    val band: ByteArray = byteArrayOf(),
    val ams: ByteArray = byteArrayOf(),
    val clock: ByteArray = byteArrayOf(),
    val callAnswerOrRedial: ByteArray = byteArrayOf(),
    val callEnd: ByteArray = byteArrayOf()
)
```

## Voz e selecao pasta/musica

O app aceita frases como:

```text
musica 1 da pasta 4
pasta 4 musica 1
proxima musica
modo usb
volume mais
eq rock
proxima musica
musica anterior
proxima sintonia
sintonia anterior
```

Essas frases sao convertidas para `RadioCommand`. No caso de `SelectFolderTrack(folder, track)`, o comando fica logico e bloqueado para envio enquanto nao houver pacote confirmado no CarLive ou no HCI Snoop Log.

Motivo: o manual confirma navegacao por `DIR-`, `DIR+`, `-10` e `+10`, mas nao confirma comando direto para abrir uma pasta e faixa por indice.

## Presets de audio/cor

O app salva presets locais com:

- EQ.
- BAS.
- TRE.
- BAL.
- FAD.
- LOUD ON/OFF.
- Cor do painel.

Aplicar um preset gera uma sequencia de `RadioCommand`, mas os comandos continuam bloqueados no encoder ate existir mapeamento confirmado dos pacotes reais.

Cor do painel exige cautela extra porque o manual cita `COR/AUTO` no painel, mas indica RGB do aplicativo como indisponivel para este modelo.

## Tabela de mapeamento a preencher

| Função | Origem no manual | Status | Bytes TX | Observação |
|---|---|---:|---|---|
| Power | Painel/app | Pendente | TODO | Ligar/desligar |
| Mode | Painel/app | Pendente | TODO | RADIO/USB/SD/AUX/BT/COR |
| Volume + | Painel/app | Pendente | TODO | Alternativa ao slider |
| Volume - | Painel/app | Pendente | TODO | Alternativa ao slider |
| Play/Pause | USB/SD/BT | Pendente | TODO | Botão 1 |
| Previous | Painel/app | Pendente | TODO | Faixa anterior |
| Next | Painel/app | Pendente | TODO | Próxima faixa |
| INT | USB/SD | Pendente | TODO | Introdução 10s |
| RPT | USB/SD | Pendente | TODO | RPT ONE/DIR/ALL |
| RDM | USB/SD | Pendente | TODO | Aleatório |
| -10 | USB/SD | Pendente | TODO | Voltar 10 faixas |
| +10 | USB/SD | Pendente | TODO | Avançar 10 faixas |
| DIR- | USB/SD | Pendente | TODO | Segurar -10 por 2s |
| DIR+ | USB/SD | Pendente | TODO | Segurar +10 por 2s |
| BAS | SEL | Pendente | TODO | -07 a +07 |
| TRE | SEL | Pendente | TODO | -07 a +07 |
| BAL | SEL | Pendente | TODO | esquerda/direita |
| FAD | SEL | Pendente | TODO | traseira/frente |
| EQ | SEL/app | Pendente | TODO | FLAT/ROCK/POP/CLASSIC/JAZZ/OFF |
| LOUD | SEL | Pendente | TODO | ON/OFF |
| AMS | App/controle | Pendente | TODO | Auto scan FM |
| BAND | FM/BT | Pendente | TODO | FM1/FM2/FM3 e atender/rediscagem |
