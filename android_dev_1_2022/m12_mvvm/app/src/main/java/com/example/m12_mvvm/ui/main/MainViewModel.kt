package com.example.m12_mvvm.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Success("Query result will be displayed here"))
    val state = _state.asStateFlow()

    init {
        Log.d(TAG, "init: $this")
    }

    fun onSearchClick(inputText: String) {
        Log.d(TAG, "onSearchClick: $inputText")
        viewModelScope.launch {
            if (inputText.isBlank() && inputText.length < 3) {
                _state.value = State.Success("Query result will be displayed here")
            } else {
                _state.value = State.Loading
                delay(5_000)
                _state.value = State.Success("No results found for \"$inputText\"")
            }
        }
    }
}