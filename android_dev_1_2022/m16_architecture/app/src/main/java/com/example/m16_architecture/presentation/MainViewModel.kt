package com.example.m16_architecture.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m16_architecture.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
) : ViewModel() {
    private val _state =
        MutableStateFlow<State>(State.Success("Query result will be displayed here"))
    val state = _state.asStateFlow()

    private val _error = Channel<String>()
    val error = _error.receiveAsFlow()

    init {
        Log.d(TAG, "init: $this")
    }

    fun reloadUsefulActivity() {
        Log.d(TAG, "reloadUsefulActivity: ...")
        viewModelScope.launch {
            try {
                _state.value = State.Loading
                val result = getUsefulActivityUseCase.execute().activity
                _state.value = State.Success(result)
            } catch (e: Exception) {
                _state.value = State.Error(e)
                _error.send(e.toString())
            }
        }
    }
}

