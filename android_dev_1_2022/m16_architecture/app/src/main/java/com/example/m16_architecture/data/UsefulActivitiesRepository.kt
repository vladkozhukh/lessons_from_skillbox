package com.example.m16_architecture.data

import com.example.m16_architecture.entity.UsefulActivity
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor(){

    suspend fun getUsefulActivity(): UsefulActivity {
        return DataSource.RetrofitService.searchImageApi.getApi()
    }
}