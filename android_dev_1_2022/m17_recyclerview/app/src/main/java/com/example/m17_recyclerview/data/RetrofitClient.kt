package com.example.m17_recyclerview.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitClient {
    private val baseUrl = "https://api.nasa.gov/mars-photos/"
    val retrofitService: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}

interface RetrofitService {
    @GET("api/v1/rovers/curiosity/photos")
    suspend fun getMarsData(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = DEMO_KEY
    ): Data

    private companion object {
        private const val DEMO_KEY = "OftrRkfauqOfpkxFE6BeOtfqB7dVBd6IZOxcJAF4"
    }
}