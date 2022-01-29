package com.example.kitchen.module17

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity(R.layout.activity_second) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sendToButton.setOnClickListener {
            val messageText = inputEditText.text.toString()
            val emailAddress = inputEditEmailAddress.text.toString()

            val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()

            if (!isEmailValid){
                toast("введен неверный адрес почты")
            } else{
                // https://developer.android.com/guide/components/intents-common#Email
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                    putExtra(Intent.EXTRA_SUBJECT, messageText)
                }
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                } else{
                    toast("Нет компонента для обработки интента")
                }
            }
        }
    }

    private fun toast(text:String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}