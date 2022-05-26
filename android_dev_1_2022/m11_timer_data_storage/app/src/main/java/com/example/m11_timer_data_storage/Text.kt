package com.example.m11_timer_data_storage

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Text(
    var text: String? = null
) : Parcelable
