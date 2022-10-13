package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Word::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}