package com.example.m9_quiz_localization.quiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Question(
    val question:String,
    val answers:List<String>,
    val feedback:List<String>,
): Parcelable