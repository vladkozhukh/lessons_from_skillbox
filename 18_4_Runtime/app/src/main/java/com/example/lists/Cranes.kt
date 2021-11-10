package com.example.lists

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Cranes: Parcelable {
    @Parcelize
    data class Tower(
        val id: Long,
        val avatarLink: String,
        val name: String,
        val jib: String,
        val lifting: String,
    ): Cranes()
    @Parcelize
    data class Auto(
        val id: Long,
        val avatarLink: String,
        val name: String,
        val jib: String,
        val lifting: String,
    ): Cranes()
}