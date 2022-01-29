package com.example.kitchen.module14

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.nameText)
        val nameInput = findViewById<EditText>(R.id.inputEditText)

        clearButton.setOnClickListener {
            makeOperationOnClick()
        }

        nameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nameTextView.text = s
                    ?.takeIf { it.isNotBlank() }
                    ?.let { it }
                //        кнопка.активна  = строка? {строк.поле.не_пусто} иначе ?: кнопка не активна
                clearButton.isEnabled = s?.let { it.isNotEmpty() } ?: false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }


    private fun makeOperationOnClick() {
        val progressBar = ProgressBar(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = when(nameText.text.toString()){
                    "s" -> Gravity.START
                    "e" -> Gravity.END
                    "c" -> Gravity.CENTER
                    "b" -> Gravity.BOTTOM
                    else -> {Gravity.CENTER_HORIZONTAL}
                }

            }
        }
        container.addView(progressBar)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                container.removeView(progressBar)
                inputEditText.setText("")
            },2000
        )
    }
}