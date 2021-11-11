package com.example.lists

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class DatasetApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}