package com.example.tocar.voice

import java.text.Normalizer
import kotlin.math.min

data class MusicEntry(
    val title: String,
    val artist: String? = null,
    val folder: Int,
    val track: Int
) {
    val spokenLabel: String
        get() = if (artist.isNullOrBlank()) {
            title
        } else {
            "$title, $artist"
        }
}

sealed interface MusicSearchResult {
    data object NoQuery : MusicSearchResult
    data class NotFound(val query: String) : MusicSearchResult
    data class Single(val entry: MusicEntry) : MusicSearchResult
    data class Multiple(val query: String, val entries: List<MusicEntry>) : MusicSearchResult
}

class MusicSearchEngine(
    private val catalogProvider: () -> List<MusicEntry> = { demoCatalog() }
) {
    fun searchVoiceText(text: String): MusicSearchResult {
        val query = extractMusicQuery(text) ?: return MusicSearchResult.NoQuery
        val matches = search(query)

        return when (matches.size) {
            0 -> MusicSearchResult.NotFound(query)
            1 -> MusicSearchResult.Single(matches.first())
            else -> MusicSearchResult.Multiple(query, matches.take(MAX_SPOKEN_OPTIONS))
        }
    }

    fun optionFromVoice(text: String, optionCount: Int): Int? {
        val normalized = text.normalizeForSearch()
        val direct = Regex("""\b(\d{1,2})\b""").find(normalized)?.groupValues?.get(1)?.toIntOrNull()
        if (direct != null && direct in 1..optionCount) return direct - 1

        val wordNumber = when {
            normalized.contains("primeira") || normalized.contains("primeiro") || normalized == "um" -> 1
            normalized.contains("segunda") || normalized.contains("segundo") || normalized == "dois" -> 2
            normalized.contains("terceira") || normalized.contains("terceiro") || normalized == "tres" -> 3
            normalized.contains("quarta") || normalized.contains("quarto") || normalized == "quatro" -> 4
            normalized.contains("quinta") || normalized.contains("quinto") || normalized == "cinco" -> 5
            else -> null
        }
        return wordNumber?.takeIf { it in 1..optionCount }?.minus(1)
    }

    fun catalogPreview(): List<MusicEntry> = catalogProvider().take(8)

    private fun search(query: String): List<MusicEntry> {
        val queryTokens = query.normalizeForSearch().tokens()
        if (queryTokens.isEmpty()) return emptyList()

        return catalogProvider()
            .mapNotNull { entry ->
                val haystack = "${entry.title} ${entry.artist.orEmpty()}".normalizeForSearch()
                val haystackTokens = haystack.tokens()
                val score = score(queryTokens, haystackTokens, haystack)
                if (score > 0) entry to score else null
            }
            .sortedWith(compareByDescending<Pair<MusicEntry, Int>> { it.second }.thenBy { it.first.title })
            .map { it.first }
    }

    private fun score(queryTokens: List<String>, haystackTokens: List<String>, haystack: String): Int {
        val queryText = queryTokens.joinToString(" ")
        if (haystack.contains(queryText)) return 100 + queryText.length

        var matched = 0
        for (queryToken in queryTokens.filter { it.length > 2 }) {
            if (haystackTokens.any { token -> token == queryToken || token.levenshteinDistance(queryToken) <= typoTolerance(queryToken) }) {
                matched++
            }
        }

        val required = min(2, queryTokens.count { it.length > 2 }).coerceAtLeast(1)
        return if (matched >= required) matched * 10 else 0
    }

    private fun typoTolerance(token: String): Int = when {
        token.length >= 7 -> 2
        token.length >= 5 -> 1
        else -> 0
    }

    private fun extractMusicQuery(text: String): String? {
        val normalized = text.normalizeForSearch()
        val patterns = listOf(
            Regex("""^(?:quero|queria|toca|tocar|coloca|procura|buscar|busca|ache|encontre)\s+(?:a\s+)?(?:musica\s+)?(.+)$"""),
            Regex("""^(?:quero ouvir|coloca ai|bota)\s+(.+)$""")
        )

        val query = patterns.firstNotNullOfOrNull { pattern ->
            pattern.find(normalized)?.groupValues?.getOrNull(1)
        } ?: return null

        return query
            .replace(Regex("""\b(no|na|do|da|por favor)\b"""), " ")
            .trim()
            .takeIf { it.length >= 3 }
    }

    private fun String.normalizeForSearch(): String {
        val withoutAccents = Normalizer.normalize(lowercase(), Normalizer.Form.NFD)
            .replace(Regex("\\p{Mn}+"), "")
        return withoutAccents
            .replace("&", " e ")
            .replace(Regex("[^a-z0-9 ]"), " ")
            .replace(Regex("\\s+"), " ")
            .trim()
    }

    private fun String.tokens(): List<String> = split(" ").filter { it.isNotBlank() }

    private fun String.levenshteinDistance(other: String): Int {
        if (this == other) return 0
        if (isEmpty()) return other.length
        if (other.isEmpty()) return length

        var previous = IntArray(other.length + 1) { it }
        var current = IntArray(other.length + 1)

        for (i in indices) {
            current[0] = i + 1
            for (j in other.indices) {
                val cost = if (this[i] == other[j]) 0 else 1
                current[j + 1] = minOf(
                    current[j] + 1,
                    previous[j + 1] + 1,
                    previous[j] + cost
                )
            }
            val swap = previous
            previous = current
            current = swap
        }
        return previous[other.length]
    }

    companion object {
        private const val MAX_SPOKEN_OPTIONS = 5

        fun demoCatalog(): List<MusicEntry> = listOf(
            MusicEntry(title = "The Rhythm of the Night", artist = "Corona", folder = 4, track = 1),
            MusicEntry(title = "Rhythm of the Night", artist = "DeBarge", folder = 4, track = 2),
            MusicEntry(title = "Rhythm Is a Dancer", artist = "Snap!", folder = 4, track = 3),
            MusicEntry(title = "Another Night", artist = "Real McCoy", folder = 5, track = 1),
            MusicEntry(title = "What Is Love", artist = "Haddaway", folder = 5, track = 2),
            MusicEntry(title = "Blue Monday", artist = "New Order", folder = 6, track = 7)
        )
    }
}
