package com.example.tocar.ui.components.retro

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tocar.ui.theme.retro.RetroColors
import com.example.tocar.ui.theme.retro.RetroDimensions
import com.example.tocar.ui.theme.retro.RetroShapes
import com.example.tocar.ui.theme.retro.RetroTypography
import androidx.compose.material3.Text

@Composable
fun RetroPlayerFrame(content: @Composable () -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(RetroColors.BorderDark)
            .border(2.dp, RetroColors.BorderLight)
            .padding(3.dp)
            .border(1.dp, RetroColors.BorderMedium)
            .padding(3.dp)
    ) { content() }
}

@Composable
fun RetroWindowHeader(
    title: String,
    powerOn: Boolean? = null,
    onPowerClick: (() -> Unit)? = null
) {
    Row(
        Modifier.fillMaxWidth().height(RetroDimensions.HeaderHeight)
            .background(Brush.verticalGradient(listOf(RetroColors.BorderMedium, RetroColors.Surface)))
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (onPowerClick != null) {
            Box(
                Modifier.width(40.dp).height(RetroDimensions.HeaderHeight)
                    .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) { onPowerClick() },
                contentAlignment = Alignment.CenterStart
            ) {
                Box(
                    Modifier.size(17.dp)
                        .background(if (powerOn == true) RetroColors.NeonGreen else RetroColors.Error, CircleShape)
                        .border(1.dp, RetroColors.BorderDark, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("⏻", color = RetroColors.TextPrimary, style = RetroTypography.Button)
                }
            }
        } else {
            Text("✣", color = RetroColors.Amber, style = RetroTypography.Window)
        }
        Spacer(Modifier.width(5.dp))
        HeaderRail(Modifier.weight(1f))
        Text("  $title  ", color = RetroColors.TextPrimary, style = RetroTypography.Window)
        HeaderRail(Modifier.weight(1f))
        Text("  − ×", color = RetroColors.Amber, style = RetroTypography.Window)
    }
}

@Composable
private fun HeaderRail(modifier: Modifier) {
    Box(modifier.height(6.dp).background(RetroColors.Amber).border(1.dp, RetroColors.BorderDark))
}

@Composable
fun RetroPanel(title: String? = null, content: @Composable () -> Unit) {
    Column(
        Modifier.fillMaxWidth().background(RetroColors.BorderDark)
            .border(1.dp, RetroColors.BorderLight).padding(2.dp)
            .border(1.dp, RetroColors.BorderMedium)
            .background(RetroColors.Surface).padding(RetroDimensions.PanelPadding)
    ) {
        if (title != null) {
            Text(title.uppercase(), color = RetroColors.NeonGreen, style = RetroTypography.Section)
            Spacer(Modifier.height(2.dp))
        }
        content()
    }
}

@Composable
fun RetroSectionTitle(title: String) = RetroWindowHeader(title)

@Composable
fun RetroButton(
    label: String,
    modifier: Modifier = Modifier,
    active: Boolean = false,
    enabled: Boolean = true,
    height: Dp = RetroDimensions.CompactButtonHeight,
    onClick: () -> Unit
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val topLeft = if (pressed) RetroColors.BorderDark else RetroColors.BorderLight
    val bottomRight = if (pressed) RetroColors.BorderLight else RetroColors.BorderDark
    val fill = when {
        !enabled -> Brush.verticalGradient(listOf(RetroColors.PanelPressed, RetroColors.BorderDark))
        active && pressed -> Brush.verticalGradient(listOf(RetroColors.ActiveMetalBottom, RetroColors.ActiveMetalTop))
        active -> Brush.verticalGradient(listOf(RetroColors.ActiveMetalTop, RetroColors.DarkGreen, RetroColors.ActiveMetalBottom))
        pressed -> Brush.verticalGradient(listOf(RetroColors.MetalBottom, RetroColors.MetalMiddle))
        else -> Brush.verticalGradient(listOf(RetroColors.MetalTop, RetroColors.MetalMiddle, RetroColors.MetalBottom))
    }
    val ink = when {
        !enabled -> RetroColors.Disabled
        active -> RetroColors.TextPrimary
        else -> RetroColors.NeonGreen
    }
    Box(
        modifier.height(height).background(fill, RetroShapes.Square)
            .drawBehind {
                drawLine(topLeft, start = androidx.compose.ui.geometry.Offset.Zero, end = androidx.compose.ui.geometry.Offset(size.width, 0f), strokeWidth = 2f)
                drawLine(topLeft, start = androidx.compose.ui.geometry.Offset.Zero, end = androidx.compose.ui.geometry.Offset(0f, size.height), strokeWidth = 2f)
                drawLine(bottomRight, start = androidx.compose.ui.geometry.Offset(0f, size.height), end = androidx.compose.ui.geometry.Offset(size.width, size.height), strokeWidth = 2f)
                drawLine(bottomRight, start = androidx.compose.ui.geometry.Offset(size.width, 0f), end = androidx.compose.ui.geometry.Offset(size.width, size.height), strokeWidth = 2f)
                val inset = 3f
                drawLine(topLeft.copy(alpha = 0.55f), start = androidx.compose.ui.geometry.Offset(inset, inset), end = androidx.compose.ui.geometry.Offset(size.width - inset, inset), strokeWidth = 1f)
                drawLine(bottomRight.copy(alpha = 0.8f), start = androidx.compose.ui.geometry.Offset(inset, size.height - inset), end = androidx.compose.ui.geometry.Offset(size.width - inset, size.height - inset), strokeWidth = 1f)
            }
            .border(1.dp, RetroColors.BorderMedium)
            .clickable(enabled = enabled, interactionSource = interaction, indication = null, onClick = onClick)
            .padding(horizontal = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(label.uppercase(), color = ink, style = RetroTypography.Button, textAlign = TextAlign.Center, maxLines = 1)
    }
}

@Composable
fun RetroActiveButton(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) =
    RetroButton(label, modifier, active = true, onClick = onClick)

@Composable
fun RetroTransportButton(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) =
    RetroButton(label, modifier, height = 32.dp, onClick = onClick)

@Composable
fun RetroSourceButton(label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) =
    RetroButton(label, modifier, active = selected, onClick = onClick)

@Composable
fun RetroSegmentedBar(value: Int, max: Int, modifier: Modifier = Modifier) {
    val count = 24
    val lit = if (max <= 0) 0 else (value * count / max).coerceIn(0, count)
    Row(modifier.height(20.dp), horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically) {
        repeat(count) { index ->
            Box(Modifier.weight(1f).height(if (index == lit) 18.dp else 7.dp).background(if (index <= lit) RetroColors.DisplayGreen else RetroColors.BorderMedium))
        }
    }
}

@Composable
fun RetroLevelMeter() {
    Row(horizontalArrangement = Arrangement.spacedBy(3.dp), verticalAlignment = Alignment.Bottom) {
        listOf(13, 20, 27, 34).forEachIndexed { index, h ->
            Box(Modifier.width(6.dp).height(h.dp).background(if (index == 3) RetroColors.Amber else RetroColors.DisplayGreen))
        }
    }
}

@Composable
fun RetroBluetoothSignal(connected: Boolean, rssi: Int?) {
    if (!connected) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier.size(28.dp).background(RetroColors.Error, CircleShape).border(1.dp, RetroColors.BorderDark, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("⌁", color = RetroColors.TextPrimary, style = RetroTypography.Window)
                Text("×", color = RetroColors.BorderDark, style = RetroTypography.Section)
            }
            Spacer(Modifier.width(6.dp))
            Text("SEM SINAL BT", color = RetroColors.Error, style = RetroTypography.Section)
        }
        return
    }

    val level = when {
        rssi == null -> 1
        rssi >= -60 -> 4
        rssi >= -72 -> 3
        rssi >= -85 -> 2
        else -> 1
    }
    Row(verticalAlignment = Alignment.Bottom) {
        Text("⌁", color = RetroColors.DisplayGreen, style = RetroTypography.Window)
        Spacer(Modifier.width(4.dp))
        repeat(4) { index ->
            Box(
                Modifier.padding(horizontal = 1.dp).width(5.dp).height((7 + index * 5).dp)
                    .background(if (index < level) RetroColors.DisplayGreen else RetroColors.BorderMedium)
            )
        }
        Spacer(Modifier.width(6.dp))
        Text(rssi?.let { "$it dBm" } ?: "LENDO...", color = RetroColors.DisplayGreen, style = RetroTypography.Helper)
    }
}

@Composable
fun RetroBottomNavigation(labels: List<String>, selectedIndex: Int, onSelected: (Int) -> Unit) {
    Column(Modifier.fillMaxWidth().background(RetroColors.Surface).navigationBarsPadding()) {
        Row(Modifier.fillMaxWidth().height(RetroDimensions.BottomNavigationHeight).border(1.dp, RetroColors.BorderMedium)) {
            labels.forEachIndexed { index, label ->
                val selected = index == selectedIndex
                Column(
                    Modifier.weight(1f).height(RetroDimensions.BottomNavigationHeight)
                        .background(if (selected) RetroColors.DarkGreen else RetroColors.Surface)
                        .border(0.5.dp, RetroColors.BorderMedium)
                        .clickable { onSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(label.take(1), color = if (selected) RetroColors.NeonGreen else RetroColors.TextSecondary, style = RetroTypography.Window)
                    Text(label.uppercase(), color = if (selected) RetroColors.NeonGreen else RetroColors.TextSecondary, style = RetroTypography.Navigation, textAlign = TextAlign.Center, maxLines = 1)
                }
            }
        }
    }
}
