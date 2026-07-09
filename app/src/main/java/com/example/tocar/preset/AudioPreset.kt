package com.example.tocar.preset

import android.content.Context
import com.example.tocar.protocol.EqPreset
import com.example.tocar.protocol.PanelColor
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.protocol.RadioState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject

data class AudioPreset(
    val id: Long,
    val name: String,
    val eqPreset: EqPreset,
    val bass: Int,
    val treble: Int,
    val balance: Int,
    val fader: Int,
    val loudness: Boolean,
    val panelColor: PanelColor
) {
    fun commands(): List<RadioCommand> = listOf(
        RadioCommand.SetEq(eqPreset),
        RadioCommand.SetBass(bass),
        RadioCommand.SetTreble(treble),
        RadioCommand.SetBalance(balance),
        RadioCommand.SetFader(fader),
        RadioCommand.SetLoudness(loudness),
        RadioCommand.SetPanelColor(panelColor)
    )
}

class PresetRepository(context: Context) {
    private val preferences = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val _presets = MutableStateFlow(loadPresets())
    val presets: StateFlow<List<AudioPreset>> = _presets.asStateFlow()

    fun saveFromState(name: String, state: RadioState) {
        val cleanName = name.trim().ifBlank { "Preset ${_presets.value.size + 1}" }
        val preset = AudioPreset(
            id = System.currentTimeMillis(),
            name = cleanName,
            eqPreset = state.eqPreset,
            bass = state.bass,
            treble = state.treble,
            balance = state.balance,
            fader = state.fader,
            loudness = state.loudness,
            panelColor = state.panelColor
        )
        val updated = (_presets.value.filterNot { it.name.equals(cleanName, ignoreCase = true) } + preset)
            .sortedBy { it.name.lowercase() }
        persist(updated)
    }

    fun delete(id: Long) {
        persist(_presets.value.filterNot { it.id == id })
    }

    private fun loadPresets(): List<AudioPreset> {
        val raw = preferences.getString(KEY_PRESETS, null) ?: return defaultPresets()
        return runCatching {
            val array = JSONArray(raw)
            List(array.length()) { index -> array.getJSONObject(index).toPreset() }
        }.getOrElse { defaultPresets() }
    }

    private fun persist(value: List<AudioPreset>) {
        val array = JSONArray()
        value.forEach { array.put(it.toJson()) }
        preferences.edit().putString(KEY_PRESETS, array.toString()).apply()
        _presets.value = value
    }

    private fun defaultPresets(): List<AudioPreset> = listOf(
        AudioPreset(
            id = 1L,
            name = "Padrao",
            eqPreset = EqPreset.FLAT,
            bass = 0,
            treble = 0,
            balance = 0,
            fader = 0,
            loudness = false,
            panelColor = PanelColor.AUTO
        )
    )

    private fun AudioPreset.toJson(): JSONObject = JSONObject()
        .put("id", id)
        .put("name", name)
        .put("eqPreset", eqPreset.name)
        .put("bass", bass)
        .put("treble", treble)
        .put("balance", balance)
        .put("fader", fader)
        .put("loudness", loudness)
        .put("panelColor", panelColor.name)

    private fun JSONObject.toPreset(): AudioPreset = AudioPreset(
        id = optLong("id", System.currentTimeMillis()),
        name = optString("name", "Preset"),
        eqPreset = enumValueOrDefault(optString("eqPreset"), EqPreset.OFF),
        bass = optInt("bass", 0),
        treble = optInt("treble", 0),
        balance = optInt("balance", 0),
        fader = optInt("fader", 0),
        loudness = optBoolean("loudness", false),
        panelColor = enumValueOrDefault(optString("panelColor"), PanelColor.AUTO)
    )

    private inline fun <reified T : Enum<T>> enumValueOrDefault(name: String?, default: T): T =
        runCatching { enumValueOf<T>(name.orEmpty()) }.getOrDefault(default)

    private companion object {
        const val PREFS_NAME = "tocar_presets"
        const val KEY_PRESETS = "audio_presets"
    }
}

