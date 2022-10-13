package com.example.m17_recyclerview.domain

import com.example.m17_recyclerview.data.RetrofitClient
import com.example.m17_recyclerview.data.RetrofitService

class RetrofitRepository {
    private var retrofitClient: RetrofitService = RetrofitClient().retrofitService
    suspend fun getData() = retrofitClient.getMarsData()
}