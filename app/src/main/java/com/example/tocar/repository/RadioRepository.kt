package com.example.tocar.repository

import com.example.tocar.bluetooth.RadioController
import com.example.tocar.logging.PacketLogger
import com.example.tocar.protocol.CommandEncoder
import com.example.tocar.protocol.EqPreset
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.protocol.RadioMode
import com.example.tocar.protocol.RadioRanges
import com.example.tocar.protocol.RadioState
import com.example.tocar.protocol.displayName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RadioRepository(
    private val bluetoothController: RadioController,
    private val encoder: CommandEncoder,
    private val logger: PacketLogger,
    private val scope: CoroutineScope
) {
    private val _radioState = MutableStateFlow(RadioState())
    val radioState: StateFlow<RadioState> = _radioState.asStateFlow()

    fun onConnectedDevice(name: String?) {
        _radioState.update { it.copy(connected = true, deviceName = name, lastMessage = "Conectado a ${name ?: "radio"}") }
    }

    fun onDisconnected() {
        _radioState.update { it.copy(connected = false, powerOn = null, deviceName = null, lastMessage = "Desconectado") }
    }

    fun onRxPacket(bytes: ByteArray) {
        logger.rx(bytes)
        _radioState.update { state ->
            when {
                bytes.size >= 4 && bytes[0] == 0x04.toByte() && bytes[1] == 0x03.toByte() -> {
                    val reportedVolume = bytes[2].toInt() and 0xFF
                    val reportedMaximum = bytes[3].toInt() and 0xFF
                    val deviceMaximum = reportedMaximum.takeIf { it > 0 } ?: state.maxVolume
                    state.copy(
                        volume = reportedVolume.coerceIn(0, deviceMaximum),
                        maxVolume = deviceMaximum,
                        lastMessage = "Volume $reportedVolume / $deviceMaximum informado pelo radio"
                    )
                }
                bytes.size >= 2 && bytes[0] == 0x08.toByte() -> {
                    val reportedMode = bytes[1].toInt() and 0xFF
                    state.copy(
                        powerOn = when (reportedMode) {
                            0x00 -> false
                            in 0x01..0x06 -> true
                            else -> state.powerOn
                        },
                        mode = when (reportedMode) {
                            0x00 -> null
                            0x02 -> RadioMode.USB
                            0x03 -> RadioMode.SD
                            0x04 -> RadioMode.RADIO
                            0x05 -> RadioMode.BT
                            0x06 -> RadioMode.AUX_IN
                            else -> state.mode
                        },
                        lastMessage = when (reportedMode) {
                            0x00 -> "Rádio confirmou POWER OFF"
                            in 0x01..0x06 -> "Rádio confirmou POWER ON"
                            else -> "Estado recebido do rádio"
                        }
                    )
                }
                bytes.size >= 4 && bytes[0] == 0x0D.toByte() && bytes[1] == 0x01.toByte() -> {
                    val rawFrequency = ((bytes[2].toInt() and 0xFF) shl 8) or (bytes[3].toInt() and 0xFF)
                    state.copy(
                        fmFrequencyMhz = rawFrequency / 100.0,
                        stationName = state.stationName ?: "FM DEMO",
                        lastMessage = "Frequência FM atualizada"
                    )
                }
                bytes.size >= 4 && bytes[0] == 0x03.toByte() && bytes[1] == 0x05.toByte() -> state.copy(
                    currentFolder = bytes[2].toInt() and 0xFF,
                    currentTrack = bytes[3].toInt() and 0xFF,
                    lastMessage = "Faixa atual informada pelo rádio"
                )
                else -> state.copy(lastMessage = "RX ${bytes.size} bytes")
            }
        }
    }

    fun send(command: RadioCommand) {
        applyOptimisticState(command)
        val encoded = encoder.encode(command)
        if (encoded == null) {
            logger.blocked("${displayName(command)} aguardando mapeamento do protocolo")
            _radioState.update { it.copy(lastMessage = "${displayName(command)}: bytes ainda nao mapeados") }
            return
        }

        scope.launch {
            runCatching {
                bluetoothController.write(encoded.bytes)
                logger.tx(encoded.source, encoded.bytes)
                _radioState.update { it.copy(lastMessage = "Enviado: ${encoded.source}") }
            }.onFailure { error ->
                logger.blocked("Falha TX ${displayName(command)}: ${error.message}")
                _radioState.update { it.copy(lastMessage = "Falha ao enviar: ${error.message ?: "SPP desconectado"}") }
            }
        }
    }

    fun setVoiceText(text: String) {
        _radioState.update { it.copy(lastVoiceText = text) }
    }

    private fun applyOptimisticState(command: RadioCommand) {
        _radioState.update { state ->
            when (command) {
                RadioCommand.VolumeUp -> state.copy(volume = (state.volume + 1).coerceAtMost(state.maxVolume))
                RadioCommand.VolumeDown -> state.copy(volume = (state.volume - 1).coerceAtLeast(0))
                is RadioCommand.SetVolume -> state.copy(volume = command.value.coerceIn(0, state.maxVolume))
                is RadioCommand.SetMode -> state.copy(mode = command.mode)
                is RadioCommand.SetEq -> state.copy(eqPreset = command.preset)
                is RadioCommand.SetBass -> state.copy(bass = command.value.coerceIn(RadioRanges.BASS_MIN, RadioRanges.BASS_MAX))
                is RadioCommand.SetTreble -> state.copy(treble = command.value.coerceIn(RadioRanges.TREBLE_MIN, RadioRanges.TREBLE_MAX))
                is RadioCommand.SetBalance -> state.copy(balance = command.value.coerceIn(RadioRanges.BALANCE_MIN, RadioRanges.BALANCE_MAX))
                is RadioCommand.SetFader -> state.copy(fader = command.value.coerceIn(RadioRanges.FADER_MIN, RadioRanges.FADER_MAX))
                is RadioCommand.SetLoudness -> state.copy(loudness = command.enabled)
                is RadioCommand.SetPanelColor -> state.copy(panelColor = command.color)
                RadioCommand.ModeNext -> {
                    val modes = RadioMode.entries
                    val current = state.mode ?: RadioMode.RADIO
                    state.copy(mode = modes[(modes.indexOf(current) + 1) % modes.size])
                }
                RadioCommand.MuteToggle,
                RadioCommand.PowerToggle,
                RadioCommand.PlayPause,
                RadioCommand.NextTrack,
                RadioCommand.PreviousTrack,
                RadioCommand.NextStation,
                RadioCommand.PreviousStation,
                RadioCommand.IntroToggle,
                RadioCommand.RepeatToggle,
                RadioCommand.RandomToggle,
                RadioCommand.SkipMinus10,
                RadioCommand.SkipPlus10,
                RadioCommand.DirectoryPrevious,
                RadioCommand.DirectoryNext,
                RadioCommand.Band,
                RadioCommand.Ams,
                RadioCommand.Clock,
                RadioCommand.CallAnswerOrRedial,
                RadioCommand.CallEnd -> state
                is RadioCommand.SelectFolderTrack -> state.copy(
                    currentFolder = command.folder,
                    currentTrack = command.track
                )
                
                is RadioCommand.Raw -> state
            }
        }
    }
}
