package com.example.room

import android.app.Application
import androidx.room.Room

class App:Application() {
    lateinit var db: AppDataBase
    private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        db = Room
            .inMemoryDatabaseBuilder(
                applicationContext,
                AppDataBase::class.java,
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object{
        lateinit var INSTANCE: App
        private set
    }
}