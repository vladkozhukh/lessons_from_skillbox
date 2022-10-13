package com.example.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Transaction
    @Query("SELECT * FROM word")
    fun getAll(): Flow<List<Word>>

    @Insert(entity = Word::class)
    suspend fun insert(word: Word)

    @Query("DELETE FROM Word")
    suspend fun delete()

    @Query("UPDATE word SET quantity = quantity + 1 WHERE word_name = :word")
    suspend fun updateQuantity(word: String)

    @Query("SELECT * FROM word WHERE word_name = :searchingWord")
    suspend fun findWord(searchingWord: String): Word?
}