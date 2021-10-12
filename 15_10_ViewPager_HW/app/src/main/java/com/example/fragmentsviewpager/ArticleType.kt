package com.example.fragmentsviewpager

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class ArticleType (
    val tag: String
        ): Parcelable {
    Sport("Спорт"),
    Health("Здоровье"),
    Business("Бизнес"),
    Auto("Автомобили"),
    Technologies("Технологии"),
    People("Люди")
}