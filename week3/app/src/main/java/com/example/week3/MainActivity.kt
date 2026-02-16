package com.example.week3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Week3 Tasks") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { context.startActivity(Intent(context, Task1Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Task 1 - State Demo")
            }

            Button(
                onClick = { context.startActivity(Intent(context, Task2Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Task 2 - Lifecycle Debug")
            }

            Button(
                onClick = { context.startActivity(Intent(context, Task3Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Task 3 - Navigation Demo")
            }

            Button(
                onClick = { context.startActivity(Intent(context, Task4Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Task 4 - Localization")
            }
        }
    }
}
