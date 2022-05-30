package com.example.m12_mvvm.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    init {
        Log.d(TAG, "init: $this")
    }

    /**
     * в [MutableStateFlow] значение должно быть по-умолчанию прописано!
     * в данном случае значение "Empty"
     */
    private val _stateFlow = MutableStateFlow<String>("Empty")
    val stateFlow = _stateFlow.asStateFlow()

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun onClick(){
        viewModelScope.launch {
            var count = 0
            while (count++ < 20){
                delay(1_000)
                val msg = "StateFlow $count"
                Log.d(TAG, "onClick: $msg")
                _stateFlow.value = msg // отображение на экране textView
            }
        }
        viewModelScope.launch {
            var count = 0
            while (count++ < 20){
                delay(1_000)
                val msg = "LiveData $count"
                Log.d(TAG, "onClick: $msg")
                _liveData.value = msg // отображение на экране textView
            }
        }
    }
}