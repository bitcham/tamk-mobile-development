package com.example.week5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week5.model.Post

@Composable
fun Week5Screen(
    modifier: Modifier = Modifier,
    timerViewModel: TimerViewModel = viewModel(),
    postsViewModel: PostsViewModel = viewModel()
) {
    val secondsElapsed by timerViewModel.secondsElapsed.collectAsState()
    val postsUiState by postsViewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            TimerCard(secondsElapsed = secondsElapsed)
        }

        item {
            ExerciseExplanationCard()
        }

        when (val state = postsUiState) {
            PostsUiState.Loading -> {
                item {
                    LoadingCard()
                }
            }

            is PostsUiState.Error -> {
                item {
                    ErrorCard(
                        message = state.message,
                        onRetry = postsViewModel::fetchPosts
                    )
                }
            }

            is PostsUiState.Success -> {
                item {
                    SummaryCard(postCount = state.posts.size)
                }

                items(
                    items = state.posts,
                    key = { post -> post.id }
                ) { post ->
                    PostCard(post = post)
                }
            }
        }
    }
}

@Composable
private fun TimerCard(secondsElapsed: Int) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Exercise 1: Timer with StateFlow",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Seconds elapsed: $secondsElapsed",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "This value is produced by TimerViewModel and observed in Compose using collectAsState().",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun ExerciseExplanationCard() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Exercise 2 + 3: Retrofit, Repository, ViewModel, UI State",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Posts are loaded from JSONPlaceholder through Retrofit, passed through a repository, stored in StateFlow, and rendered below.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun SummaryCard(postCount: Int) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Loaded successfully",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Total posts fetched: $postCount",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun LoadingCard() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CircularProgressIndicator()
            Text(
                text = "Loading posts from the API...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun ErrorCard(
    message: String,
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Request failed",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = onRetry) {
                Text("Retry")
            }
        }
    }
}

@Composable
private fun PostCard(post: Post) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Post #${post.id}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
