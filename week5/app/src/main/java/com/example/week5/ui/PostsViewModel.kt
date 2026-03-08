package com.example.week5.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _uiState = MutableStateFlow<PostsUiState>(PostsUiState.Loading)
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            _uiState.value = PostsUiState.Loading
            _uiState.value = runCatching { repository.fetchPosts() }
                .fold(
                    onSuccess = { PostsUiState.Success(it) },
                    onFailure = {
                        Log.e(TAG, "Failed to fetch posts", it)
                        PostsUiState.Error(it.message ?: "Unknown network error")
                    }
                )
        }
    }

    companion object {
        private const val TAG = "PostsViewModel"
    }
}
