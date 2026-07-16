package com.example.tocar.protocol

enum class RadioMode(val label: String) {
    RADIO("Radio"),
    USB("USB"),
    SD("SD"),
    AUX_IN("AUX"),
    BT("Bluetooth"),
    COLOR("Cor")
}

enum class EqPreset(val label: String) {
    FLAT("Flat"),
    ROCK("Rock"),
    POP("Pop"),
    CLASSIC("Classic"),
    JAZZ("Jazz"),
    OFF("Off")
}

enum class PanelColor(val label: String, val hex: String) {
    AUTO("Auto", "#FFFFFF"),
    RED("Vermelho", "#E53935"),
    GREEN("Verde", "#43A047"),
    BLUE("Azul", "#1E88E5"),
    AMBER("Ambar", "#FFB300"),
    CYAN("Ciano", "#00ACC1"),
    WHITE("Branco", "#F5F5F5"),
    OFF("Desligado", "#202124")
}

object RadioRanges {
    const val BASS_MIN = -7
    const val BASS_MAX = 7
    const val TREBLE_MIN = -7
    const val TREBLE_MAX = 7
    const val BALANCE_MIN = -7
    const val BALANCE_MAX = 7
    const val FADER_MIN = -7
    const val FADER_MAX = 7
}

data class RadioState(
    val connected: Boolean = false,
    val deviceName: String? = null,
    val mode: RadioMode? = null,
    val fmFrequencyMhz: Double? = null,
    val stationName: String? = null,
    val volume: Int = 18,
    val bass: Int = 0,
    val treble: Int = 0,
    val balance: Int = 0,
    val fader: Int = 0,
    val eqPreset: EqPreset = EqPreset.OFF,
    val loudness: Boolean = false,
    val panelColor: PanelColor = PanelColor.AUTO,
    val lastVoiceText: String? = null,
    val lastMessage: String = "Pronto para conectar ao Roadstar"
)
