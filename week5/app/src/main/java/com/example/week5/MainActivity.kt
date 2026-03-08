package com.example.week5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.week5.ui.Week5Screen
import com.example.week5.ui.theme.Week5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week5Theme {
                Week5App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Week5App() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Weekly Exercises 5") }
            )
        }
    ) { innerPadding ->
        Week5Screen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
