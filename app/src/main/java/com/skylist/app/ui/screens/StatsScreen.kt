package com.skylist.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatsScreen() {
    val weekly = mapOf("Mon" to 20, "Tue" to 35, "Wed" to 15, "Thu" to 28, "Fri" to 44, "Sat" to 52, "Sun" to 39)
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Total listening time: 14h 32m", style = MaterialTheme.typography.titleLarge)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            weekly.forEach { (day, value) ->
                Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                    Box(
                        Modifier
                            .width(20.dp)
                            .height((value + 20).dp)
                            .background(Color(0xFF7B68EE), shape = MaterialTheme.shapes.small)
                    )
                    Text(day)
                }
            }
        }
        Text("Most played songs", style = MaterialTheme.typography.titleMedium)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(listOf("Starlight Run", "Neon Path", "Ocean Air")) {
                Card(Modifier.fillMaxWidth()) { Text(it, modifier = Modifier.padding(16.dp)) }
            }
        }
    }
}
