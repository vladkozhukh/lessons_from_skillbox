package com.example.m16_architecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val mainViewModel: MainViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return mainViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}