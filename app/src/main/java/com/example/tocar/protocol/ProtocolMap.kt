package com.example.tocar.protocol

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

data class EncodedCommand(
    val bytes: ByteArray,
    val source: String
)

class CommandEncoder(
    private val protocolMap: ProtocolMap = ProtocolMap()
) {
    fun encode(command: RadioCommand): EncodedCommand? {
        val packet = when (command) {
            RadioCommand.PowerToggle -> protocolMap.powerToggle
            RadioCommand.MuteToggle -> protocolMap.muteToggle
            RadioCommand.ModeNext -> protocolMap.modeNext
            RadioCommand.PlayPause -> protocolMap.playPause
            RadioCommand.NextTrack -> protocolMap.nextTrack
            RadioCommand.PreviousTrack -> protocolMap.previousTrack
            RadioCommand.NextStation -> null
            RadioCommand.PreviousStation -> null
            RadioCommand.IntroToggle -> protocolMap.introToggle
            RadioCommand.RepeatToggle -> protocolMap.repeatToggle
            RadioCommand.RandomToggle -> protocolMap.randomToggle
            RadioCommand.SkipMinus10 -> protocolMap.skipMinus10
            RadioCommand.SkipPlus10 -> protocolMap.skipPlus10
            RadioCommand.DirectoryPrevious -> protocolMap.directoryPrevious
            RadioCommand.DirectoryNext -> protocolMap.directoryNext
            RadioCommand.VolumeUp -> protocolMap.volumeUp
            RadioCommand.VolumeDown -> protocolMap.volumeDown
            RadioCommand.Band -> protocolMap.band
            RadioCommand.Ams -> protocolMap.ams
            RadioCommand.Clock -> protocolMap.clock
            RadioCommand.CallAnswerOrRedial -> protocolMap.callAnswerOrRedial
            RadioCommand.CallEnd -> protocolMap.callEnd
            is RadioCommand.Raw -> command.bytes.takeIf { it.isNotEmpty() && it.size <= MAX_RAW_PACKET_SIZE }
            is RadioCommand.SetMode,
            is RadioCommand.SetVolume,
            is RadioCommand.SetEq,
            is RadioCommand.SetBass,
            is RadioCommand.SetTreble,
            is RadioCommand.SetBalance,
            is RadioCommand.SetFader,
            is RadioCommand.SetLoudness,
            is RadioCommand.SetPanelColor,
            is RadioCommand.SelectFolderTrack -> null
        }

        return packet?.takeIf { it.isNotEmpty() }?.let {
            EncodedCommand(bytes = it, source = command.displayName())
        }
    }

    companion object {
        const val MAX_RAW_PACKET_SIZE = 32
    }
}
