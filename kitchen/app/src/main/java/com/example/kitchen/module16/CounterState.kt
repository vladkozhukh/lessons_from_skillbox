package com.example.kitchen.module16

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CounterState(
    val count: Int,
    val message: String
) : Parcelable {
    fun increment(): CounterState {
        return copy(count = count + 1)
    }
    fun decrement(): CounterState {
        return copy(count = count - 1)
    }
}