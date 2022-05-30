package com.example.m12_mvvm.ui.main

sealed class State{
    object Success: State()
    object Loading: State()
    data class Error(
        val inputTextError:String?
    ): State()
}