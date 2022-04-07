package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.m3_components.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    private val scope = CoroutineScope(Job() + Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewTimer.text = binding.slider.valueFrom.toInt().toString()

        val update = {
            binding.apply {
                progressBarCircular.apply {
                    max = slider.valueFrom.toInt()
                    progress = slider.valueFrom.toInt()
                }
            }
        }
        update.invoke()

        binding.slider.addOnChangeListener { _, value, _ ->
            binding.textViewTimer.text = value.toInt().toString()
            binding.progressBarCircular.let {
                it.max = value.toInt()
                it.progress = value.toInt()
            }
        }

        val currentCount = binding.progressBarCircular.max

        binding.start.setOnClickListener {
            binding.slider.isEnabled = false
            binding.start.text = getString(R.string.stop)
                startCountDownTimer(currentCount.toLong()*1000)
            var count = binding.progressBarCircular.progress
            scope.launch(Dispatchers.Default) {
                while (count >= 0) {
                    count--
                    binding.progressBarCircular.progress = count
                    delay(1000)
                }
                binding.slider.isEnabled = true
                binding.start.text = getString(R.string.start)
                update.invoke()
            }
        }
    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1) {
            override fun onTick(time: Long) {
                binding.textViewTimer.text = (time / 1000).toString()
            }

            override fun onFinish() {
                binding.textViewTimer.text = binding.progressBarCircular.max.toString()
            }
        }.start()
    }
}