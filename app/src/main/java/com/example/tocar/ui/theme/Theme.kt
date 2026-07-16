package com.example.tocar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PlayerGreen,
    onPrimary = PlayerBlack,
    primaryContainer = PlayerGreenDim,
    onPrimaryContainer = PlayerBlack,
    secondary = PlayerSilver,
    onSecondary = PlayerBlack,
    tertiary = PlayerAmber,
    error = PlayerRed,
    background = PlayerBlack,
    onBackground = PlayerSilver,
    surface = PlayerPanel,
    onSurface = PlayerSilver,
    surfaceContainer = PlayerPanel,
    surfaceContainerHigh = PlayerPanelRaised,
    onSurfaceVariant = Color(0xFF9AA39B),
    outline = PlayerOutline,
    outlineVariant = Color(0xFF303630)
)

@Composable
fun ToCarTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
