package com.example.kitchen.module16

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_parcelable.*

class MainActivity : AppCompatActivity() {

    private var state: CounterState = CounterState(0, " ")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)
        updateTextView()
        setEmailParamsFromIntent()

        incrementButton.setOnClickListener {
            state = state.increment()
            updateTextView()

        }
        decrementButton.setOnClickListener {
            state = state.decrement()
            updateTextView()
        }
    }

    private fun setEmailParamsFromIntent() {
        val address = intent.getStringArrayExtra(Intent.EXTRA_EMAIL)
        val message = intent.getStringExtra(Intent.EXTRA_SUBJECT)
        textViewFromEmail.text = message ?: ("message is not set")
        emailViewFromEmail.text = address?.joinToString() ?: ("Email address is not set")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_COUNTER, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getParcelable(KEY_COUNTER) ?: error("Unexpected count")
        updateTextView()
    }

    private fun updateTextView() {
        textViewState.text = state.count.toString()
    }

    companion object {
        private const val KEY_COUNTER = "key counter"
    }
}