package com.example.kitchen.module14

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_dynamic.*
import kotlinx.android.synthetic.main.item_view.view.*
import kotlin.random.Random

class DynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        addTextButton.setOnClickListener {
            addText()
        }

        addViewButton.setOnClickListener {
            addView()
        }
    }

    private fun addView() {
        val textToAdd = inputText.text.toString()
        val view = layoutInflater.inflate(R.layout.item_view, containerDynamic, false)
        view.apply {
            textView.text = textToAdd
            deleteButton.setOnClickListener {
                containerDynamic.removeView(view)
            }
        }
        containerDynamic.addView(view)
    }

    private fun addText() {
        val textToAdd = inputText.text.toString()
        val textView = TextView(this).apply {
            text = textToAdd
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = when(Random.nextInt(3)){
                    1 -> Gravity.START
                    2 -> Gravity.CENTER
                    3 -> Gravity.END
                    else -> Gravity.CENTER_HORIZONTAL
                }
            }
        }
        containerDynamic.addView(textView)
    }
}