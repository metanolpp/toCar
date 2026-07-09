package com.example.tocar

import com.example.tocar.protocol.EqPreset
import com.example.tocar.protocol.PanelColor
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.protocol.RadioMode
import com.example.tocar.voice.MusicSearchEngine
import com.example.tocar.voice.MusicSearchResult
import com.example.tocar.voice.VoiceCommandParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class VoiceCommandParserTest {
    private val parser = VoiceCommandParser()
    private val musicSearch = MusicSearchEngine()

    @Test
    fun parsesMusicFromFolder() {
        val command = parser.parse("musica 1 da pasta 4")

        assertEquals(RadioCommand.SelectFolderTrack(folder = 4, track = 1), command)
    }

    @Test
    fun parsesFolderThenMusic() {
        val command = parser.parse("pasta 4 musica 1")

        assertEquals(RadioCommand.SelectFolderTrack(folder = 4, track = 1), command)
    }

    @Test
    fun parsesCommonRadioCommands() {
        assertEquals(RadioCommand.NextTrack, parser.parse("proxima musica"))
        assertEquals(RadioCommand.VolumeUp, parser.parse("aumentar volume"))
        assertEquals(RadioCommand.SetMode(RadioMode.USB), parser.parse("modo usb"))
        assertEquals(RadioCommand.SetEq(EqPreset.ROCK), parser.parse("eq rock"))
        assertTrue(parser.parse("comando inexistente") == null)
    }

    @Test
    fun parsesNextTrackAndStationCommands() {
        assertEquals(RadioCommand.NextTrack, parser.parse("proxima musica"))
        assertEquals(RadioCommand.PreviousTrack, parser.parse("musica anterior"))
        assertEquals(RadioCommand.NextStation, parser.parse("proxima sintonia"))
        assertEquals(RadioCommand.PreviousStation, parser.parse("sintonia anterior"))
    }

    @Test
    fun parsesBroadAppCommands() {
        assertEquals(RadioCommand.PowerToggle, parser.parse("ligar radio"))
        assertEquals(RadioCommand.MuteToggle, parser.parse("silenciar"))
        assertEquals(RadioCommand.Ams, parser.parse("buscar radios"))
        assertEquals(RadioCommand.Band, parser.parse("banda"))
        assertEquals(RadioCommand.Clock, parser.parse("relogio"))
        assertEquals(RadioCommand.CallAnswerOrRedial, parser.parse("atender chamada"))
        assertEquals(RadioCommand.CallEnd, parser.parse("encerrar chamada"))
        assertEquals(RadioCommand.SetPanelColor(PanelColor.BLUE), parser.parse("cor azul"))
    }

    @Test
    fun parsesPresetName() {
        assertEquals("rock estrada", parser.parsePresetName("aplicar preset rock estrada"))
    }

    @Test
    fun parsesNaturalSourceCommands() {
        assertEquals(RadioCommand.SetMode(RadioMode.RADIO), parser.parse("radio FM"))
        assertEquals(RadioCommand.SetMode(RadioMode.USB), parser.parse("USB"))
        assertEquals(RadioCommand.SetMode(RadioMode.BT), parser.parse("bluetooth"))
        assertEquals(RadioCommand.SetMode(RadioMode.AUX_IN), parser.parse("auxiliar"))
    }

    @Test
    fun searchesMusicByApproximateVoiceTitle() {
        val result = musicSearch.searchVoiceText("quero this is ritmym of the night")

        assertTrue(result is MusicSearchResult.Multiple)
        val titles = (result as MusicSearchResult.Multiple).entries.map { it.title }
        assertTrue(titles.any { it.contains("Rhythm", ignoreCase = true) })
    }

    @Test
    fun selectsPendingMusicOptionByNumber() {
        assertEquals(1, musicSearch.optionFromVoice("2", optionCount = 3))
        assertEquals(2, musicSearch.optionFromVoice("terceira", optionCount = 3))
    }
}
