package com.example.m14_retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersModels(
    @Json(name = "results")
    val results: List<Result>
)

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "gender")
    val gender: String,
    @Json(name = "name")
    val name: Name,
    @Json(name = "picture")
    val picture: Picture
)

@JsonClass(generateAdapter = true)
data class Picture(
    @Json(name = "large")
    val large: String,
    @Json(name = "medium")
    val medium: String,
    @Json(name = "thumbnail")
    val thumbnail: String
)

@JsonClass(generateAdapter = true)
data class Name(
    @Json(name = "first")
    val first: String,
    @Json(name = "last")
    val last: String,
    @Json(name = "title")
    val title: String
)