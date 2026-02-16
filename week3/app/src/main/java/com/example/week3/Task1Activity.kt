package com.example.week3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class Task1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Task1Screen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task1Screen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.state_demo_title)) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.state_demo_subtitle),
                style = MaterialTheme.typography.bodyLarge
            )

            StateSection(
                title = stringResource(R.string.remember_section_title),
                explanation = stringResource(R.string.remember_explanation),
                useSaveable = false
            )

            HorizontalDivider()

            StateSection(
                title = stringResource(R.string.saveable_section_title),
                explanation = stringResource(R.string.saveable_explanation),
                useSaveable = true
            )
        }
    }
}

@Composable
fun StateSection(
    title: String,
    explanation: String,
    useSaveable: Boolean
) {
    var name by if (useSaveable) {
        rememberSaveable { mutableStateOf("") }
    } else {
        remember { mutableStateOf("") }
    }

    var count by if (useSaveable) {
        rememberSaveable { mutableStateOf(0) }
    } else {
        remember { mutableStateOf(0) }
    }

    val displayName = name.ifBlank { stringResource(R.string.default_name) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.name_input_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(R.string.hello_name, displayName),
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = stringResource(R.string.counter_text, count),
            style = MaterialTheme.typography.headlineSmall
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { count++ }) {
                Text(stringResource(R.string.increment_button))
            }
            OutlinedButton(onClick = {
                name = ""
                count = 0
            }) {
                Text(stringResource(R.string.reset_button))
            }
        }

        InfoCard(
            title = title,
            description = explanation
        )
    }
}
