package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldAppTheme {
                //HelloWorldScreen() // exercise 3
                ComposablesPlayground() // exercise 4
            }
        }
    }
}

@Composable
fun HelloWorldScreen() {
    var clickCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title Text
        Text(
            text = "Hello, World!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Subtitle Text
        Text(
            text = "Chambit Oh!",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Interactive Button
        Button(
            onClick = { clickCount++ },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Click me!")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Click counter Card
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "Button clicked: $clickCount times",
                modifier = Modifier.padding(16.dp),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Additional UI Composables demonstration
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AssistChip(
                onClick = { },
                label = { Text("Chip 1") }
            )
            AssistChip(
                onClick = { },
                label = { Text("Chip 2") }
            )
            AssistChip(
                onClick = { },
                label = { Text("Chip 3") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Switch example
        var switchState by remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Toggle me:")
            Switch(
                checked = switchState,
                onCheckedChange = { switchState = it }
            )
        }
    }
}


// Preview annotation
@Preview(showBackground = true, name = "Light Mode")
@Composable
fun HelloWorldScreenPreview() {
    HelloWorldAppTheme {
        HelloWorldScreen()
    }
}

// Dark mode preview
@Preview(showBackground = true, name = "Dark Mode")
@Composable
fun HelloWorldScreenDarkPreview() {
    HelloWorldAppTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            HelloWorldScreen()
        }
    }
}
