package com.example.tocar.voice

import com.example.tocar.protocol.EqPreset
import com.example.tocar.protocol.PanelColor
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.protocol.RadioMode

class VoiceCommandParser {
    fun parse(input: String): RadioCommand? {
        val text = normalize(input)

        parseFolderTrack(text)?.let { return it }

        return when {
            text.hasAny("ligar radio", "desligar radio", "liga radio", "desliga radio", "power") -> RadioCommand.PowerToggle
            text.hasAny("trocar modo", "proximo modo", "mudar modo") -> RadioCommand.ModeNext
            text.hasAny("proxima sintonia", "sintonia proxima", "proxima estacao", "estacao proxima") -> RadioCommand.NextStation
            text.hasAny("sintonia anterior", "estacao anterior") -> RadioCommand.PreviousStation
            text.hasAny("proxima musica", "proxima faixa", "avancar faixa", "passa musica") -> RadioCommand.NextTrack
            text.hasAny("musica anterior", "faixa anterior", "voltar faixa") -> RadioCommand.PreviousTrack
            text.hasAny("play", "tocar", "pause", "pausar") -> RadioCommand.PlayPause
            text.hasAny("volume mais", "aumentar volume", "volume acima") -> RadioCommand.VolumeUp
            text.hasAny("volume menos", "baixar volume", "diminuir volume") -> RadioCommand.VolumeDown
            text.hasAny("mudo", "mute", "silenciar") -> RadioCommand.MuteToggle
            text.hasAny("radio fm", "modo radio", "ir para radio") || text == "radio" -> RadioCommand.SetMode(RadioMode.RADIO)
            text.hasAny("modo usb", "ir para usb") || text == "usb" -> RadioCommand.SetMode(RadioMode.USB)
            text.hasAny("modo sd", "cartao sd") -> RadioCommand.SetMode(RadioMode.SD)
            text.hasAny("bluetooth", "modo bt") || text == "bt" -> RadioCommand.SetMode(RadioMode.BT)
            text.hasAny("auxiliar", "modo auxiliar") || text == "aux" -> RadioCommand.SetMode(RadioMode.AUX_IN)
            text.hasAny("repetir", "repeat") -> RadioCommand.RepeatToggle
            text.hasAny("aleatorio", "random") -> RadioCommand.RandomToggle
            text.hasAny("introducao", "intro") -> RadioCommand.IntroToggle
            text.hasAny("ams", "buscar radios", "auto scan") -> RadioCommand.Ams
            text.hasAny("banda", "band") -> RadioCommand.Band
            text.hasAny("relogio", "clock") -> RadioCommand.Clock
            text.hasAny("atender chamada", "atender telefone") -> RadioCommand.CallAnswerOrRedial
            text.hasAny("encerrar chamada", "desligar chamada") -> RadioCommand.CallEnd
            text.hasAny("pasta anterior") -> RadioCommand.DirectoryPrevious
            text.hasAny("proxima pasta", "pasta proxima") -> RadioCommand.DirectoryNext
            text.hasAny("eq rock") -> RadioCommand.SetEq(EqPreset.ROCK)
            text.hasAny("eq pop") -> RadioCommand.SetEq(EqPreset.POP)
            text.hasAny("eq classic", "eq classico") -> RadioCommand.SetEq(EqPreset.CLASSIC)
            text.hasAny("eq jazz") -> RadioCommand.SetEq(EqPreset.JAZZ)
            text.hasAny("eq flat") -> RadioCommand.SetEq(EqPreset.FLAT)
            text.hasAny("loud on", "loudness on", "ativar loud") -> RadioCommand.SetLoudness(true)
            text.hasAny("loud off", "loudness off", "desativar loud") -> RadioCommand.SetLoudness(false)
            text.hasAny("cor vermelha", "painel vermelho") -> RadioCommand.SetPanelColor(PanelColor.RED)
            text.hasAny("cor verde", "painel verde") -> RadioCommand.SetPanelColor(PanelColor.GREEN)
            text.hasAny("cor azul", "painel azul") -> RadioCommand.SetPanelColor(PanelColor.BLUE)
            text.hasAny("cor ambar", "painel ambar") -> RadioCommand.SetPanelColor(PanelColor.AMBER)
            text.hasAny("cor ciano", "painel ciano") -> RadioCommand.SetPanelColor(PanelColor.CYAN)
            text.hasAny("cor branca", "painel branco") -> RadioCommand.SetPanelColor(PanelColor.WHITE)
            text.hasAny("cor auto", "painel automatico") -> RadioCommand.SetPanelColor(PanelColor.AUTO)
            text.hasAny("apagar painel", "painel desligado") -> RadioCommand.SetPanelColor(PanelColor.OFF)
            else -> null
        }
    }

    fun parsePresetName(input: String): String? {
        val text = normalize(input)
        val match = Regex("""(?:aplicar|usar|ativar|carregar)\s+preset\s+(.+)""").find(text)
            ?: Regex("""^preset\s+(.+)""").find(text)
        return match?.groupValues?.getOrNull(1)?.trim()?.takeIf { it.isNotBlank() }
    }

    private fun parseFolderTrack(text: String): RadioCommand.SelectFolderTrack? {
        val patterns = listOf(
            Regex("""musica\s+(\d+)\s+(?:da|de)\s+pasta\s+(\d+)"""),
            Regex("""pasta\s+(\d+)\s+musica\s+(\d+)"""),
            Regex("""tocar\s+(\d+)\s+(?:da|de)\s+pasta\s+(\d+)""")
        )

        for (pattern in patterns) {
            val match = pattern.find(text) ?: continue
            val first = match.groupValues[1].toIntOrNull() ?: continue
            val second = match.groupValues[2].toIntOrNull() ?: continue
            val folder = if (text.startsWith("pasta")) first else second
            val track = if (text.startsWith("pasta")) second else first
            if (folder in 1..999 && track in 1..999) {
                return RadioCommand.SelectFolderTrack(folder = folder, track = track)
            }
        }
        return null
    }

    private fun String.hasAny(vararg terms: String): Boolean = terms.any { contains(it) }

    private fun normalize(input: String): String =
        input.lowercase()
            .replace("música", "musica")
            .replace("próxima", "proxima")
            .replace("próximo", "proximo")
            .replace("rádio", "radio")
            .replace("âmbar", "ambar")
            .replace("automático", "automatico")
}
