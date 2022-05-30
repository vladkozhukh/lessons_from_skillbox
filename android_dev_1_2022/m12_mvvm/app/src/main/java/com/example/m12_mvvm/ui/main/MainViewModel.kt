package com.example.m12_mvvm.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Success)
    val state = _state.asStateFlow()

    private val _error = Channel<String>()
    val error = _error.receiveAsFlow()

    init {
        Log.d(TAG, "init: $this")
    }

    fun onSearchClick(inputText: String) {
        Log.d(TAG, "onSearchClick: $inputText")
        viewModelScope.launch {
            val isInputTextEmpty = inputText.isBlank()
            if (isInputTextEmpty) {
                var inputTextError: String? = null
                if (isInputTextEmpty) {
                    inputTextError = "Input text is required"
                }
                _state.value = State.Error(inputTextError)
                _error.send("Please, input text more than three symbols")
            } else {
                _state.value = State.Loading
                delay(10_000)
                _state.value = State.Success
            }
        }
    }
}