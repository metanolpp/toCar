package com.example.tocar

import com.example.tocar.voice.MusicEntry
import com.example.tocar.voice.MusicSearchEngine
import com.example.tocar.voice.MusicSearchResult
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MusicSearchPlaylistTest {
    @Test
    fun `voice search uses current indexed playlist`() {
        var playlist = listOf(MusicEntry("Outra música", folder = 2, track = 3))
        val engine = MusicSearchEngine { playlist }
        playlist = playlist + MusicEntry("Hoje a noite não tem luar", "Legião Urbana", folder = 10, track = 1)

        val result = engine.searchVoiceText("toca hoje a noite nao tem luar")

        assertTrue(result is MusicSearchResult.Single)
        result as MusicSearchResult.Single
        assertEquals(10, result.entry.folder)
        assertEquals(1, result.entry.track)
    }
}
