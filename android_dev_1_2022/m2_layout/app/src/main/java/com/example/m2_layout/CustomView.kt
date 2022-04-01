package com.example.m2_layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.m2_layout.databinding.CustomViewBinding


class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val view = CustomViewBinding.inflate(LayoutInflater.from(context))

    init {
        addView(view.root)
    }

    fun setStringTextUp(text: String) {
        view.tvString1.text = text
    }
    fun setStringTextDown(text: String) {
        view.tvString2.text = text
    }
}