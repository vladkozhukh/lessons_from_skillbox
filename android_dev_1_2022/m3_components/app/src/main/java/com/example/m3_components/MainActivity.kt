package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.m3_components.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val MAX = 100
private const val MIN = 0
private const val INCREMENT = 10

class MainActivity : AppCompatActivity() {

    private var currentProgress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val updateProgress = {
            binding.progressBarCircular.progress = currentProgress
        }

        binding.increment.setOnClickListener {
            if (currentProgress < MAX) {
                currentProgress += INCREMENT
                updateProgress.invoke()
            } else {
                if (currentProgress >= MAX) {
                    currentProgress = INCREMENT
                    updateProgress.invoke()
                }
            }
        }

        binding.decrement.setOnClickListener {
            if (currentProgress > MIN) {
                currentProgress -= INCREMENT
                updateProgress.invoke()
            }
        }
        binding.checkbox.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                binding.decrement.isEnabled = true
                binding.increment.isEnabled = isCheck
                checked("Checked")
            } else {
                binding.decrement.isEnabled = false
                binding.increment.isEnabled = isCheck
                checked("Unchecked")
            }
        }
        binding.switchMaterial.setOnCheckedChangeListener { _, isSwitch ->
            if (isSwitch) {
                binding.imageView.setColorFilter(getColor(R.color.purple_500))
                checked("Switch on")
            } else {
                binding.imageView.setColorFilter(getColor(android.R.color.darker_gray))
                checked("Switch off")
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { _, id ->
            when (id) {
                binding.radioButtonOne.id -> showSnackBar("one checked")
                binding.radioButtonTwo.id -> showSnackBar("two checked")
            }
        }
    }

    private fun checked(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(message: String) {
        val contextView = findViewById<View>(android.R.id.content)
        Snackbar.make(contextView, message, Snackbar.LENGTH_LONG)
            .setAction("close") {
                // Responds to click on the action
            }
            .setBackgroundTint(contextView.context.getColor(R.color.purple_200))
            .setActionTextColor(contextView.context.getColor(R.color.white))
            .show()
    }

}