package com.skylist.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }
    val allItems = listOf("Starlight - Aurora", "Moonline - Vega", "Lunar Waves - Orbit", "Nova Artist")
    val results = allItems.filter { it.contains(query, true) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Search songs or artists") }
        )
        LazyColumn(Modifier.padding(top = 12.dp)) {
            items(results) { item ->
                Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Text(item, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
