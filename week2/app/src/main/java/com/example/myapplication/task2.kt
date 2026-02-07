package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Task2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                InfoCardScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoCardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Info Cards") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
        ) {
            InfoCard(
                title = "Garlic",
                description = "A pungent bulb used to add deep flavor to sauces, stir-fries, and marinades."
            )
            InfoCard(
                title = "Olive Oil",
                description = "A healthy cooking oil pressed from olives, great for frying, dressings, and baking."
            )
            InfoCard(
                title = "Basil",
                description = "A fragrant herb commonly used in pasta, pizza, and salads for a fresh aroma."
            )
        }
    }
}
