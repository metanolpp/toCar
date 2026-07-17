package com.example.tocar.ui.theme.retro

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val scheme = darkColorScheme(
    primary = RetroColors.NeonGreen,
    onPrimary = RetroColors.Background,
    background = RetroColors.Background,
    onBackground = RetroColors.TextPrimary,
    surface = RetroColors.Surface,
    onSurface = RetroColors.TextPrimary,
    outline = RetroColors.BorderMedium,
    error = RetroColors.Error
)

@Composable
fun ToCarRetroTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = scheme, content = content)
}
