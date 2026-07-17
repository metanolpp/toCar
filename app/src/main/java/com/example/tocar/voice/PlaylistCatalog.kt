package com.example.tocar.voice

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File

class PlaylistCatalog(context: Context) {
    private val indexFile = File(context.filesDir, FILE_NAME)
    private val _entries = MutableStateFlow(load())
    val entries: StateFlow<List<MusicEntry>> = _entries.asStateFlow()

    fun add(entry: MusicEntry) {
        val normalized = entry.copy(
            title = entry.title.trim(),
            artist = entry.artist?.trim()?.takeIf { it.isNotEmpty() },
            folder = entry.folder.coerceIn(0, 255),
            track = entry.track.coerceIn(0, 255)
        )
        if (normalized.title.isBlank()) return
        _entries.value = _entries.value
            .filterNot { it.folder == normalized.folder && it.track == normalized.track } + normalized
        persist(_entries.value)
    }

    private fun load(): List<MusicEntry> {
        if (!indexFile.exists()) {
            val initial = MusicSearchEngine.demoCatalog()
            persist(initial)
            return initial
        }
        return indexFile.readLines().drop(1).mapNotNull { line ->
            val fields = line.split('\t')
            if (fields.size < 5) return@mapNotNull null
            MusicEntry(
                folder = fields[1].toIntOrNull() ?: return@mapNotNull null,
                track = fields[2].toIntOrNull() ?: return@mapNotNull null,
                title = fields[3].unescapeField(),
                artist = fields[4].unescapeField().takeIf { it.isNotBlank() }
            )
        }
    }

    private fun persist(entries: List<MusicEntry>) {
        indexFile.parentFile?.mkdirs()
        indexFile.bufferedWriter().use { writer ->
            writer.appendLine("INDEX\tFOLDER\tTRACK\tTITLE\tARTIST")
            entries.forEachIndexed { index, entry ->
                writer.appendLine(
                    listOf(index + 1, entry.folder, entry.track, entry.title.escapeField(), entry.artist.orEmpty().escapeField()).joinToString("\t")
                )
            }
        }
    }

    private fun String.escapeField() = replace("\\", "\\\\").replace("\t", "\\t").replace("\n", "\\n")
    private fun String.unescapeField() = replace("\\n", "\n").replace("\\t", "\t").replace("\\\\", "\\")

    companion object { const val FILE_NAME = "playlist_index.txt" }
}
