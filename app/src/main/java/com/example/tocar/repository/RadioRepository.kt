package com.example.tocar.repository

import com.example.tocar.bluetooth.AndroidBluetoothController
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
    private val bluetoothController: AndroidBluetoothController,
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
        _radioState.update { it.copy(connected = false, deviceName = null, lastMessage = "Desconectado") }
    }

    fun onRxPacket(bytes: ByteArray) {
        logger.rx(bytes)
        _radioState.update { it.copy(lastMessage = "RX ${bytes.size} bytes") }
    }

    fun send(command: RadioCommand) {
        applyOptimisticState(command)
        val encoded = encoder.encode(command)
        if (encoded == null) {
            logger.blocked("${command.displayName()} aguardando mapeamento do protocolo")
            _radioState.update { it.copy(lastMessage = "${command.displayName()}: bytes ainda nao mapeados") }
            return
        }

        scope.launch {
            runCatching {
                bluetoothController.write(encoded.bytes)
                logger.tx(encoded.source, encoded.bytes)
                _radioState.update { it.copy(lastMessage = "Enviado: ${encoded.source}") }
            }.onFailure { error ->
                logger.blocked("Falha TX ${command.displayName()}: ${error.message}")
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
                RadioCommand.VolumeUp -> state.copy(volume = (state.volume + 1).coerceAtMost(40))
                RadioCommand.VolumeDown -> state.copy(volume = (state.volume - 1).coerceAtLeast(0))
                is RadioCommand.SetVolume -> state.copy(volume = command.value.coerceIn(0, 40))
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
                RadioCommand.CallEnd,
                is RadioCommand.SelectFolderTrack,
                is RadioCommand.Raw -> state
            }
        }
    }
}
