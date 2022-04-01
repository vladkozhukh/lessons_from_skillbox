package com.example.m2_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m2_layout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customView.setStringTextUp("Вверхняя строчка и какой-то длинный текст")
        binding.customView.setStringTextDown("Нижняя строчка и какой-то длинный текст")

        binding.textViewActivity.text = "Текст активити"


    }


}