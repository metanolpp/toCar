package com.example.tocar.protocol

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

fun RadioCommand.displayName(): String = when (this) {
    RadioCommand.PowerToggle -> "Power"
    RadioCommand.MuteToggle -> "Mute"
    RadioCommand.ModeNext -> "Mode"
    is RadioCommand.SetMode -> "Modo ${mode.label}"
    RadioCommand.PlayPause -> "Play/Pause"
    RadioCommand.NextTrack -> "Proxima faixa"
    RadioCommand.PreviousTrack -> "Faixa anterior"
    RadioCommand.NextStation -> "Proxima sintonia"
    RadioCommand.PreviousStation -> "Sintonia anterior"
    RadioCommand.IntroToggle -> "INT"
    RadioCommand.RepeatToggle -> "RPT"
    RadioCommand.RandomToggle -> "RDM"
    RadioCommand.SkipMinus10 -> "-10"
    RadioCommand.SkipPlus10 -> "+10"
    RadioCommand.DirectoryPrevious -> "DIR-"
    RadioCommand.DirectoryNext -> "DIR+"
    RadioCommand.VolumeUp -> "Volume +"
    RadioCommand.VolumeDown -> "Volume -"
    is RadioCommand.SetVolume -> "Volume $value"
    RadioCommand.Band -> "Band"
    RadioCommand.Ams -> "AMS"
    RadioCommand.Clock -> "Clock"
    RadioCommand.CallAnswerOrRedial -> "Atender/rediscar"
    RadioCommand.CallEnd -> "Encerrar chamada"
    is RadioCommand.SetEq -> "EQ ${preset.label}"
    is RadioCommand.SetBass -> "BAS $value"
    is RadioCommand.SetTreble -> "TRE $value"
    is RadioCommand.SetBalance -> "BAL $value"
    is RadioCommand.SetFader -> "FAD $value"
    is RadioCommand.SetLoudness -> "LOUD ${if (enabled) "ON" else "OFF"}"
    is RadioCommand.SetPanelColor -> "Cor ${color.label}"
    is RadioCommand.SelectFolderTrack -> "Pasta $folder, musica $track"
    is RadioCommand.Raw -> "Raw ${bytes.size} bytes"
}
