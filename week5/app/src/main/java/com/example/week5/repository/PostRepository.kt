package com.example.week5.repository

import android.util.Log
import com.example.week5.model.Post
import com.example.week5.network.RetrofitClient

class PostRepository {
    suspend fun fetchPosts(): List<Post> {
        val posts = RetrofitClient.api.getPosts()
        Log.d(TAG, "Fetched ${posts.size} posts")
        Log.d(TAG, "Fetched posts payload: $posts")
        return posts
    }

    companion object {
        private const val TAG = "PostRepository"
    }
}
