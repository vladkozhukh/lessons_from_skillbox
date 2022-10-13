package com.example.m12_mvvm.ui.main

sealed class State {
    data class Success(val message: String?) : State()
    object Loading : State()
}