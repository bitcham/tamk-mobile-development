package com.example.week5.network

import com.example.week5.model.Post
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
