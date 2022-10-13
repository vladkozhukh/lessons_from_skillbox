package com.example.m14_retrofit.ui.main

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatImageModel(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String
)