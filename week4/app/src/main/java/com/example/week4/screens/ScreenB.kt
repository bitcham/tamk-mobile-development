package com.example.week4.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week4.exercises.exercise2Results
import com.example.week4.exercises.exercise3Results
import com.example.week4.viewmodel.CounterViewModel

@Composable
fun ScreenB(viewModel: CounterViewModel) {
    val count by viewModel.count.collectAsState()
    val exercise2 = remember { exercise2Results() }
    val exercise3 = remember { exercise3Results() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Screen B",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Shared Counter (ViewModel)",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Counter: $count",
                        style = MaterialTheme.typography.displaySmall
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { viewModel.increment() }) {
                            Text("+ Increment")
                        }
                        Button(onClick = { viewModel.decrement() }) {
                            Text("- Decrement")
                        }
                    }
                }
            }
        }

        item {
            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Exercise 2 Results",
                        style = MaterialTheme.typography.titleMedium
                    )
                    exercise2.forEach { line ->
                        Text(text = line, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        item {
            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Exercise 3 Results",
                        style = MaterialTheme.typography.titleMedium
                    )
                    exercise3.forEach { line ->
                        Text(text = line, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        item {
            Text(
                text = "Observe that this counter stays synchronized with Screen A while navigating tabs.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
