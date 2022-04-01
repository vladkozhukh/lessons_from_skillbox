package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.m3_components.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private var maxTimer = 0
    private val minTimer = 0
    private val incrementTimer = 1
    private var currentProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        maxTimer = binding.slider.valueFrom.toInt()
        binding.progressBarCircular.max = binding.slider.value.toInt()

        val updateProgressBar = {
            binding.progressBarCircular.progress = currentProgress
            binding.textViewTimer.text = (maxTimer - currentProgress).toString()
        }

        binding.slider.addOnChangeListener { _, value, _ ->
            binding.progressBarCircular.max = value.toInt()
            maxTimer = value.toInt()
            updateProgressBar.invoke()
        }

        binding.increment.setOnClickListener {
            if (maxTimer > currentProgress) {
                currentProgress += incrementTimer
                updateProgressBar.invoke()
            } else {
                if (currentProgress >= maxTimer) {
                    currentProgress = incrementTimer
                    updateProgressBar.invoke()
                }
            }
        }

        binding.decrement.setOnClickListener {
            if (currentProgress > minTimer) {
                currentProgress -= incrementTimer
                updateProgressBar.invoke()
            }
        }
        binding.checkbox.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                binding.decrement.isEnabled = true
                binding.increment.isEnabled = isCheck
                binding.slider.isEnabled = isCheck
                binding.textViewTimer.setTextColor(resources.getColor(R.color.purple_500))
                checked("Checked")
            } else {
                binding.decrement.isEnabled = false
                binding.increment.isEnabled = isCheck
                binding.slider.isEnabled = isCheck
                binding.textViewTimer.setTextColor(resources.getColor(android.R.color.darker_gray))
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