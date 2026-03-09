package com.skylist.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    val albums = listOf("Night Drive", "Sky Echoes", "Neon Drift", "Cloud Harbor")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Recently Played", style = MaterialTheme.typography.titleLarge)
        LazyRow(contentPadding = PaddingValues(horizontal = 4.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(albums) { album ->
                Card(modifier = Modifier.fillParentMaxWidth(0.6f)) {
                    Column(Modifier.padding(16.dp)) {
                        Text(album, style = MaterialTheme.typography.titleMedium)
                        Text("Recommended mix", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
