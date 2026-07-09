# ToCar — Telas Jetpack Compose

## Navegação

```kotlin
sealed class ToCarRoute(val route: String) {
    data object Bluetooth : ToCarRoute("bluetooth")
    data object MainControls : ToCarRoute("main_controls")
    data object FileBrowser : ToCarRoute("file_browser")
    data object AudioSettings : ToCarRoute("audio_settings")
    data object DeveloperLog : ToCarRoute("developer_log")
}
```

## BluetoothScreen

### Funções

- Pedir permissões Bluetooth.
- Exibir dispositivos encontrados.
- Destacar nomes compatíveis: CAR-BT, RS-2751BR, CAR KIT-APP.
- Conectar via SPP.
- Mostrar estados: Desconectado, Buscando, Conectando, Conectado, Erro.

### UI State

```kotlin
data class BluetoothUiState(
    val connectionState: BluetoothConnectionState = BluetoothConnectionState.Disconnected,
    val devices: List<BluetoothDeviceInfo> = emptyList(),
    val permissionsGranted: Boolean = false,
    val error: String? = null
)
```

## MainControlsScreen

### Funções

- Power.
- Mode.
- Botões diretos de fonte.
- Volume.
- Play/Pause.
- Próximo/Anterior.
- Mute.
- RPT/RDM/INT.
- -10/+10.
- DIR-/DIR+.
- Chamada.

### UI State

```kotlin
data class MainControlsUiState(
    val connected: Boolean = false,
    val mode: RadioMode? = null,
    val volume: Int = 0,
    val trackName: String? = null,
    val repeatMode: String? = null,
    val randomEnabled: Boolean = false,
    val introEnabled: Boolean = false
)
```

### Ações

```kotlin
fun onPlayPause() = send(RadioCommand.PlayPause)
fun onNext() = send(RadioCommand.NextTrack)
fun onPrevious() = send(RadioCommand.PreviousTrack)
fun onVolumeUp() = send(RadioCommand.VolumeUp)
fun onVolumeDown() = send(RadioCommand.VolumeDown)
fun onModeNext() = send(RadioCommand.ModeNext)
fun onSetMode(mode: RadioMode) = send(RadioCommand.SetMode(mode))
fun onRepeat() = send(RadioCommand.RepeatToggle)
fun onRandom() = send(RadioCommand.RandomToggle)
fun onIntro() = send(RadioCommand.IntroToggle)
fun onMinus10() = send(RadioCommand.SkipMinus10)
fun onPlus10() = send(RadioCommand.SkipPlus10)
fun onDirectoryPrevious() = send(RadioCommand.DirectoryPrevious)
fun onDirectoryNext() = send(RadioCommand.DirectoryNext)
```

## FileBrowserScreen

### Observação
O manual confirma reprodução MP3/WMA com troca de pastas, mas não confirma que o aplicativo consiga listar árvore de arquivos. Então essa tela deve começar como experimental.

### Funções iniciais seguras

- DIR-.
- DIR+.
- -10.
- +10.
- Próximo/Anterior.

### Funções experimentais

- Solicitar lista de diretórios.
- Interpretar resposta do rádio.
- Entrar em pasta.
- Executar arquivo selecionado.

### Modelo

```kotlin
sealed interface FileEntry {
    data class Folder(val name: String, val index: Int) : FileEntry
    data class AudioFile(val name: String, val index: Int) : FileEntry
}
```

## AudioSettingsScreen

### Funções

- BAS -07 a +07.
- TRE -07 a +07.
- BAL.
- FAD.
- EQ.
- LOUD.
- AUTO/COR com cautela.
- Salvar preset local de EQ/BAS/TRE/BAL/FAD/LOUD/cor.
- Aplicar preset salvo.
- Apagar preset salvo.

### UI State

```kotlin
data class AudioSettingsUiState(
    val bass: Int = 0,
    val treble: Int = 0,
    val balance: Int = 0,
    val fader: Int = 0,
    val eqPreset: EqPreset = EqPreset.OFF,
    val loudness: Boolean = false,
    val colorModeAvailable: Boolean = false,
    val selectedPanelColor: PanelColor = PanelColor.AUTO,
    val presets: List<AudioPreset> = emptyList()
)
```

### Ações

```kotlin
fun onBassChanged(value: Int) = send(RadioCommand.SetBass(value))
fun onTrebleChanged(value: Int) = send(RadioCommand.SetTreble(value))
fun onBalanceChanged(value: Int) = send(RadioCommand.SetBalance(value))
fun onFaderChanged(value: Int) = send(RadioCommand.SetFader(value))
fun onEqChanged(preset: EqPreset) = send(RadioCommand.SetEq(preset))
fun onLoudnessChanged(enabled: Boolean) = send(RadioCommand.SetLoudness(enabled))
```

## DeveloperLogScreen

### Objetivo
Ajudar na engenharia reversa.

### Exibir

- Timestamp.
- Direção: TX/RX.
- Nome lógico do comando, quando conhecido.
- Bytes em hexadecimal.
- Tamanho do pacote.
- Campo de anotação manual.

### Exemplo

```text
2026-07-07 18:35:11.120 TX NEXT_TRACK  AA 55 03 10 01 0F
2026-07-07 18:35:11.214 RX STATUS      AA 55 04 90 02 01 0D
```
