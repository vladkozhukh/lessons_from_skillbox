package com.example.m16_architecture.data

import com.example.m16_architecture.entity.UsefulActivity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class UsefulActivityDto(
    @Json(name = "activity") override val activity: String,
    @Json(name = "key") override val key: String,
    @Json(name = "link") override val link: String,
    @Json(name = "price") override val price: String,
    @Json(name = "accessibility") override val accessibility: String,
    @Json(name = "type") override val type: String,
    @Json(name = "participants") override val participants: String
) : UsefulActivity
