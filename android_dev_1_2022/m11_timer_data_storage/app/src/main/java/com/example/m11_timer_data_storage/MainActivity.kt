package com.example.m11_timer_data_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m11_timer_data_storage.databinding.ActivityMainBinding

const val KEY_VALUE = "VALUE"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository = Repository()
    private var editTextValue = Text() // Parcelize Text()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      binding.editText.setText(repository.getText(this)) - отображение значения в editText
        binding.textField.text = repository.getText(this) // - отображение значения в textView

        binding.saveButton.setOnClickListener {
            editTextValue.text = binding.editText.text.toString()
            repository.saveText(editTextValue.text.toString(), this)
            binding.textField.text = repository.getText(this)
            toast("saved!")
        }

        binding.clearButton.setOnClickListener {
            binding.textField.text = repository.clearText(this)
            toast("cleared!")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_VALUE, editTextValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getParcelable<Text>(KEY_VALUE)
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}