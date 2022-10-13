package com.example.m16_architecture.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class DataSource {
    object RetrofitService {
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val searchImageApi: SearchSource = retrofit.create(SearchSource::class.java)
    }

    interface SearchSource {
        @GET("/api/activity/")
        suspend fun getApi(): UsefulActivityDto // десериализации данных
    }

    companion object {
        // установить дату на эмуляторе не позднее 30.мая.2022, есть перебои в api
        private const val BASE_URL = "https://www.boredapi.com/"
    }
}