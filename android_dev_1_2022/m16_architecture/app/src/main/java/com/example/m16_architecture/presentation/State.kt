package com.example.m16_architecture.presentation

sealed class State {
    data class Success(val message: String?) : State()
    data class Error(val message: Exception) : State()
    object Loading : State()
}

