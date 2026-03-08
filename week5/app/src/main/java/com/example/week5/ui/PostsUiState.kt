package com.example.week5.ui

import com.example.week5.model.Post

sealed interface PostsUiState {
    data object Loading : PostsUiState

    data class Success(val posts: List<Post>) : PostsUiState

    data class Error(val message: String) : PostsUiState
}
