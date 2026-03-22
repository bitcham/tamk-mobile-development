package com.example.week6catfacts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://catfact.ninja/"

interface CatFactApiService {
    @GET("fact")
    suspend fun getRandomFact(): CatFactResponse
}

object CatFactService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: CatFactApiService by lazy {
        retrofit.create(CatFactApiService::class.java)
    }
}

