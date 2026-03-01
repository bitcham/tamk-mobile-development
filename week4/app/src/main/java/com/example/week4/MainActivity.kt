package com.example.week4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.week4.navigation.AppNavigation
import com.example.week4.ui.theme.Week4Theme
import com.example.week4.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {

    // ViewModel scoped to the Activity — shared across both screens
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4Theme {
                AppNavigation(viewModel = counterViewModel)
            }
        }
    }
}
