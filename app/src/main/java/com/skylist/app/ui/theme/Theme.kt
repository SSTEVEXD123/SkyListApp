package com.skylist.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val SkyColors = darkColorScheme(
    primary = Color(0xFF9E8CFF),
    secondary = Color(0xFF6BD6FF),
    surface = Color(0xFF111322),
    background = Color(0xFF0A0C16)
)

@Composable
fun SkyListTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SkyColors,
        content = content
    )
}
