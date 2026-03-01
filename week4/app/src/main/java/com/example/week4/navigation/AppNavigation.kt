package com.example.week4.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.week4.screens.ScreenA
import com.example.week4.screens.ScreenB
import com.example.week4.viewmodel.CounterViewModel

// ============================================================
// Exercise 5 — Bottom Tab Navigation
// ============================================================

/*
 Navigation pattern chosen: Bottom Tab Navigation

 Where is this commonly used?
   Bottom tab navigation is used in most popular apps: Instagram, YouTube,
   Spotify, Twitter/X, etc. It provides quick access to top-level destinations
   that the user switches between frequently.

 What kind of apps benefit from it?
   Apps with 2-5 main sections that are equally important and frequently accessed.
   It works well when users need to jump between sections without losing state
   (e.g., Home, Search, Profile). It's the most common navigation pattern on mobile.

 What I learned while testing it:
   - NavController manages the back stack and current destination
   - NavigationBar + NavigationBarItem create the bottom tabs
   - currentBackStackEntryAsState() lets us highlight the active tab
   - The ViewModel is shared across both tabs because it's scoped to the activity
*/

// Define the navigation destinations
sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object ScreenA : Screen("screen_a", "Screen A", Icons.Default.Home)
    data object ScreenB : Screen("screen_b", "Screen B", Icons.Default.Settings)
}

@Composable
fun AppNavigation(viewModel: CounterViewModel) {
    val navController = rememberNavController()
    val screens = listOf(Screen.ScreenA, Screen.ScreenB)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                screens.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to start destination to avoid building up a large stack
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected tab
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.ScreenA.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.ScreenA.route) {
                ScreenA(viewModel = viewModel)
            }
            composable(Screen.ScreenB.route) {
                ScreenB(viewModel = viewModel)
            }
        }
    }
}
