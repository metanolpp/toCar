package com.example.tocar.protocol

fun ByteArray.toHexString(): String = joinToString(" ") { byte ->
    "%02X".format(byte.toInt() and 0xFF)
}

fun String.hexToByteArraySafe(maxBytes: Int = CommandEncoder.MAX_RAW_PACKET_SIZE): Result<ByteArray> = runCatching {
    val clean = trim()
        .replace("0x", "", ignoreCase = true)
        .replace(Regex("[^A-Fa-f0-9]"), "")

    require(clean.isNotEmpty()) { "Informe bytes em hexadecimal." }
    require(clean.length % 2 == 0) { "Hexadecimal incompleto." }
    require(clean.length / 2 <= maxBytes) { "Pacote Raw limitado a $maxBytes bytes." }

    clean.chunked(2)
        .map { it.toInt(16).toByte() }
        .toByteArray()
}

