package com.example.room

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val wordDao = (application as App).db.wordDao()
                return MainViewModel(wordDao) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.isEnabled = false

        binding.inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (validate(binding.inputText.text.toString()))
                    binding.addButton.isEnabled = true
                else {
                    binding.addButton.isEnabled = false
                    binding.inputText.error = "error"
                }
            }
        })

        binding.addButton.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            viewModel.onAdd(inputText)
        }

        binding.deleteButton.setOnClickListener { viewModel.onDelete() }

        lifecycleScope.launchWhenCreated {
            viewModel.allWords
                .collect { word ->
                    binding.textView.text = word.joinToString(
                        separator = "\r\n"
                    )
                }
        }
    }

    private fun validate(text: String?): Boolean {
        val pattern = Pattern.compile("^[A-Za-z\\-]{1,20}\$")
        val matcher = text?.let { pattern.matcher(it) }
        return matcher?.matches() == true
    }
}