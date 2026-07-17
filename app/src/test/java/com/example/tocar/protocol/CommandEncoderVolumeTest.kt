package com.example.tocar.protocol

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class CommandEncoderVolumeTest {
    private val encoder = CommandEncoder()

    @Test
    fun `encodes absolute volume with device protocol`() {
        val encoded = encoder.encode(RadioCommand.SetVolume(63))

        assertArrayEquals(byteArrayOf(0x04, 0x03, 0x3F), encoded?.bytes)
    }

    @Test
    fun `radio state defaults to physical maximum volume`() {
        assertEquals(63, RadioState().maxVolume)
    }

    @Test
    fun `encodes indexed playlist folder and track`() {
        val encoded = encoder.encode(RadioCommand.SelectFolderTrack(folder = 10, track = 1))

        assertArrayEquals(byteArrayOf(0x03, 0x05, 0x0A, 0x01), encoded?.bytes)
    }

    @Test
    fun `encodes power using confirmed CarLive packet`() {
        assertArrayEquals(byteArrayOf(0x01, 0x01), encoder.encode(RadioCommand.PowerToggle)?.bytes)
    }

    @Test
    fun `rejects volume outside one byte`() {
        assertNull(encoder.encode(RadioCommand.SetVolume(256)))
        assertNull(encoder.encode(RadioCommand.SetVolume(-1)))
    }
}
