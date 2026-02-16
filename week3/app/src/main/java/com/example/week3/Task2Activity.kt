package com.example.week3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class Task2Activity : ComponentActivity() {

    private val tag = "Task2Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContent {
            MaterialTheme {
                Task2Screen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task2Screen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.lifecycle_debug_title)) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard(
                title = stringResource(R.string.lifecycle_debug_title),
                description = stringResource(R.string.lifecycle_debug_body)
            )

            Text(
                text = stringResource(R.string.navigate_to_exercises),
                style = MaterialTheme.typography.titleMedium
            )

            Button(
                onClick = { context.startActivity(Intent(context, Task1Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.state_demo_title))
            }

            Button(
                onClick = { context.startActivity(Intent(context, Task3Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.navigation_demo_title))
            }

            Button(
                onClick = { context.startActivity(Intent(context, Task4Activity::class.java)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.localization_hint))
            }
        }
    }
}
