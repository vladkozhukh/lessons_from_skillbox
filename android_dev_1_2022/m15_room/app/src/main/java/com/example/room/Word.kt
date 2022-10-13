package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "word")
data class Word(
    @ColumnInfo(name = "id")
    val id: UUID,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @PrimaryKey
    @ColumnInfo(name = "word_name")
    val wordName: String
)
