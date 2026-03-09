package com.skylist.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.skylist.app.ui.navigation.Screen
import com.skylist.app.ui.screens.HomeScreen
import com.skylist.app.ui.screens.LibraryScreen
import com.skylist.app.ui.screens.PlayerScreen
import com.skylist.app.ui.screens.SearchScreen
import com.skylist.app.ui.screens.StatsScreen

@Composable
fun SkyListApp() {
    val navController = rememberNavController()
    val tabs = listOf(
        Triple(Screen.Home, "Home", Icons.Default.Home),
        Triple(Screen.Search, "Search", Icons.Default.Search),
        Triple(Screen.Library, "Library", Icons.Default.LibraryMusic),
        Triple(Screen.Player, "Player", Icons.Default.PlayCircle),
        Triple(Screen.Stats, "Stats", Icons.Default.Equalizer)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination
                tabs.forEach { (screen, label, icon) ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = { navController.navigate(screen.route) },
                        icon = { Icon(icon, contentDescription = label) },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Search.route) { SearchScreen() }
            composable(Screen.Library.route) { LibraryScreen() }
            composable(Screen.Player.route) { PlayerScreen() }
            composable(Screen.Stats.route) { StatsScreen() }
        }
    }
}
