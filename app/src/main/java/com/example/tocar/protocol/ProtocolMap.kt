package com.example.tocar.protocol

data class ProtocolMap(
    val powerToggle: ByteArray = byteArrayOf(0x01, 0x01),
    val muteToggle: ByteArray = byteArrayOf(0x09, 0x01),
    val modeNext: ByteArray = byteArrayOf(0x08, 0x01),
    val playPause: ByteArray = byteArrayOf(),
    val nextTrack: ByteArray = byteArrayOf(0x03, 0x02, 0x00),
    val previousTrack: ByteArray = byteArrayOf(0x03, 0x01, 0x00),
    val introToggle: ByteArray = byteArrayOf(),
    val repeatToggle: ByteArray = byteArrayOf(),
    val randomToggle: ByteArray = byteArrayOf(),
    val skipMinus10: ByteArray = byteArrayOf(0x03, 0x03),
    val skipPlus10: ByteArray = byteArrayOf(0x03, 0x04),
    val directoryPrevious: ByteArray = byteArrayOf(0x03, 0x09),
    val directoryNext: ByteArray = byteArrayOf(0x03, 0x08),
    val volumeUp: ByteArray = byteArrayOf(0x04, 0x02),
    val volumeDown: ByteArray = byteArrayOf(0x04, 0x01),
    val band: ByteArray = byteArrayOf(0x07, 0x01),
    val ams: ByteArray = byteArrayOf(0x07, 0x02),
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
            is RadioCommand.SetMode -> when (command.mode) {
                RadioMode.RADIO -> byteArrayOf(0x08, 0x04)
                RadioMode.USB -> byteArrayOf(0x08, 0x02)
                RadioMode.SD -> byteArrayOf(0x08, 0x03)
                RadioMode.AUX_IN -> byteArrayOf(0x08, 0x06)
                RadioMode.BT -> byteArrayOf(0x08, 0x05)
                RadioMode.COLOR -> null
            }
            
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
            EncodedCommand(bytes = it, source = displayName(command))
        }
    }

    companion object {
        const val MAX_RAW_PACKET_SIZE = 32
    }
}
