package com.example.week3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class Task4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Task4Screen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task4Screen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.localization_hint)) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InfoCard(
                title = stringResource(R.string.localization_hint),
                description = stringResource(R.string.welcome_description)
            )

            InfoCard(
                title = stringResource(R.string.welcome_title),
                description = stringResource(R.string.welcome_back)
            )

            InfoCard(
                title = stringResource(R.string.username_label),
                description = stringResource(R.string.login_button) + " / " + stringResource(R.string.cancel_button)
            )

            InfoCard(
                title = stringResource(R.string.state_demo_title),
                description = stringResource(R.string.state_demo_subtitle)
            )

            InfoCard(
                title = stringResource(R.string.lifecycle_debug_title),
                description = stringResource(R.string.lifecycle_debug_body)
            )

            InfoCard(
                title = stringResource(R.string.navigation_demo_title),
                description = stringResource(R.string.home_screen_welcome) + " · " +
                        stringResource(R.string.go_to_details) + " · " +
                        stringResource(R.string.back_button)
            )
        }
    }
}
