package com.example.room

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(
    private val wordDao: WordDao
) : ViewModel() {
    val allWords = this.wordDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptyList()
        )

    fun onAdd(inputText: String) {
        viewModelScope.launch {
            try {
                wordDao.insert(
                    Word(wordName = inputText, quantity = 1, id = UUID.randomUUID())
                )
            } catch (e: SQLiteConstraintException) {
                wordDao.findWord(inputText)
                viewModelScope.launch {
                    allWords.value.lastOrNull()?.let {
                        inputText
                    }
                    wordDao.updateQuantity(inputText)
                }
            }
        }
    }

    fun onDelete() {
        viewModelScope.launch {
            allWords.value.let {
                wordDao.delete()
            }
        }
    }
}