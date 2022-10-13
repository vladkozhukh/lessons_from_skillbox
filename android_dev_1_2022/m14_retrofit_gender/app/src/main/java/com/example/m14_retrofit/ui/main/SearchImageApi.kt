package com.example.m14_retrofit.ui.main

import com.example.m14_retrofit.UsersModels
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me"

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val searchImageApi: SearchImageApi = retrofit.create(SearchImageApi::class.java)
}

interface SearchImageApi {
    @GET("/api/?results=1&inc=gender,picture,name&noinfo")
    suspend fun getUserImage(): Response<UsersModels>
}