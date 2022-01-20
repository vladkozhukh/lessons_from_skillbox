package com.example.kitchen.module14

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.nameText)
        val nameInput = findViewById<EditText>(R.id.inputText)

        clearButton.setOnClickListener {
            nameInput.setText("")
            Toast.makeText(this, "очищен текст", Toast.LENGTH_SHORT).show()
        }

        nameInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nameTextView.text = s?.takeIf { it.isNotBlank() }?.let { it }

                //        кнопка.активна  = строка? {строк.поле.не_пусто} иначе ?: кнопка не активна
                clearButton.isEnabled = s?.let { it.isNotEmpty() } ?: false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })


    }
}