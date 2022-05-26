package com.example.m11_timer_data_storage


import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE

const val PREFERENCE_NAME = "prefs_name"
const val SHARED_PREFS_KEY = "shared_prefs_name"


class Repository {
    private var localValue: String? = null

    // будет доставать значение из SharedPreference
    private fun getDataFromSharedPreference(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        return prefs.getString(SHARED_PREFS_KEY, "SharedPreference")
    }

    // будет доставать значение, возвращать значение локальной переменной;
    private fun getDataFromLocalVariable(): String? {
        return localValue
    }

    // будет записывать значения:
    fun saveText(text: String, activity: Activity) {
        // и в SharedPreference,
        val sharedPref = activity.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(SHARED_PREFS_KEY, text)
            apply()
        }
        // и в локальную переменную.
        localValue = text
    }

    // будет очищать значение...
    fun clearText(context: Context): String {
        localValue = null
        val sharedPref = context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(SHARED_PREFS_KEY, null)
            apply()
        }
        return "(пустая строчка)"
    }

    // будет доставать значение из источников...
    fun getText(context: Context): String {
        return when {
            //сначала попытается взять значение локальной переменной
            localValue != null -> getDataFromLocalVariable()!!
            // если оно null, то попытаемся взять значение из SharedPreference.
            localValue == null -> getDataFromSharedPreference(context)!!
            else -> "no one source doesn't contain string"
        }
    }
}