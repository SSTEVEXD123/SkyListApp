package com.skylist.app.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Lyrics
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skylist.app.data.LyricLine

@Composable
fun PlayerScreen() {
    var isPlaying by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0.3f) }
    var showLyrics by remember { mutableStateOf(true) }
    val lyrics = remember {
        listOf(
            LyricLine(0, "City lights are fading"),
            LyricLine(5000, "Skyline starts to glow"),
            LyricLine(10000, "Every beat keeps moving"),
            LyricLine(15000, "Where the starlight flows")
        )
    }
    val activeIndex = ((progress * lyrics.size).toInt()).coerceIn(0, lyrics.lastIndex)

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Brush.linearGradient(listOf(Color(0xFF1B1D38), Color(0xFF3A2E72))), shape = MaterialTheme.shapes.extraLarge)
        )
        Text("Starlight Run", style = MaterialTheme.typography.headlineSmall)
        Text("Aurora", style = MaterialTheme.typography.bodyLarge)
        Slider(value = progress, onValueChange = { progress = it })

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = {}) { Icon(Icons.Default.Shuffle, null) }
            IconButton(onClick = {}) { Icon(Icons.Default.SkipPrevious, null) }
            FilledIconButton(onClick = { isPlaying = !isPlaying }) {
                Icon(if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow, null)
            }
            IconButton(onClick = {}) { Icon(Icons.Default.SkipNext, null) }
            IconButton(onClick = {}) { Icon(Icons.Default.Repeat, null) }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = { showLyrics = !showLyrics }) { Icon(Icons.Default.Lyrics, null); Text(" Lyrics") }
            OutlinedButton(onClick = {}) { Icon(Icons.Default.FormatListBulleted, null); Text(" Queue") }
            OutlinedButton(onClick = {}) { Icon(Icons.Default.Groups, null); Text(" Listen Together") }
        }

        if (showLyrics) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(lyrics) { index, line ->
                    val alpha by animateFloatAsState(if (index == activeIndex) 1f else 0.45f, label = "lyric-alpha")
                    Text(
                        line.text,
                        modifier = Modifier.alpha(alpha),
                        style = if (index == activeIndex) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
