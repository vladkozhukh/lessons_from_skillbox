package com.example.m10_timer_life_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m10_timer_life_cycle.databinding.ActivityMainBinding
import kotlinx.coroutines.*


private const val KEY_BOOLEAN = "Boolean"
private const val KEY_INT = "Int"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private var isTimerRunning = false
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateViewProgressBar()

        // slider addOnChange
        binding.slider.addOnChangeListener { _, value, _ ->
            count = value.toInt()
            binding.apply {
                textViewTimer.text = count.toString()
                progressBarCircular.progress = count
                progressBarCircular.max = count
            }
            // update View after sliderChange
            updateViewProgressBar()
        }

        binding.start.setOnClickListener {
            if (!isTimerRunning) {
                isTimerRunning = true
                interfaceDisplayState()
                toast("timer task started!")
                (binding.progressBarCircular.progress > 0)
                count = binding.slider.value.toInt()
                coroutineScopeLaunch()
            } else {
                isTimerRunning = false
                interfaceDisplayState()
                toast("timer task stopped!")
                updateViewProgressBar()
            }
        }

    }

    private fun coroutineScopeLaunch() {
        isTimerRunning = true
        val job = scope.launch(Dispatchers.Main) {
            while (binding.progressBarCircular.progress > 0) {
                binding.progressBarCircular.progress = count
                binding.textViewTimer.text = count.toString()
                count--
                delay(1000)


            }
            isTimerRunning = false
            interfaceDisplayState()
            toast("timer task finished!")
        }
        scope.launch {
            while (true) {
                if (isTimerRunning) {
                    job.start()
                } else {
                    job.cancel()
                    withContext(Dispatchers.Main) {
                        updateViewProgressBar()
                    }
                }
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_INT)
        isTimerRunning = savedInstanceState.getBoolean(KEY_BOOLEAN)
        if (!isTimerRunning) {
            interfaceDisplayState()
            updateViewProgressBar()
        } else {
            interfaceDisplayState()
            coroutineScopeLaunch()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INT, count)
        outState.putBoolean(KEY_BOOLEAN, isTimerRunning)
    }


    private fun updateViewProgressBar() {
        binding.slider.value.let {
            binding.apply {
                textViewTimer.text = it.toInt().toString()
                progressBarCircular.progress = it.toInt()
                progressBarCircular.max = it.toInt()
            }
        }
    }

    private fun interfaceDisplayState() {
        if (isTimerRunning) {
            binding.slider.isEnabled = false
            binding.start.text = getString(R.string.stop)
        } else {
            binding.slider.isEnabled = true
            binding.start.text = getString(R.string.start)
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

