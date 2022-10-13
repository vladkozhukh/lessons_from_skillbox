package com.example.m17_recyclerview.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m17_recyclerview.data.Photo
import com.example.m17_recyclerview.domain.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MarsViewModel(
    private val retrofitRepository: RetrofitRepository
) : ViewModel() {
    constructor() : this(RetrofitRepository())

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photos = _photos.asStateFlow()

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                _isLoading.value = true
                retrofitRepository.getData()
            }.fold(
                onSuccess = { _photos.value = it.photos},
                onFailure = { Log.d(TAG, it.message ?: "") }
            )
            _isLoading.value = false
        }
    }
}