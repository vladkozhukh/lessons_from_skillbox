package com.example.kitchen.module15

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_coordinator.*

class CoordinatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator)

        goToToolbarActivity.setOnClickListener {
            val messageText = messageEditText.text.toString()
//            val toolbarActivityIntent = Intent(
//                this,
//                ToolbarActivity::class.java
//            ).putExtra(ToolbarActivity.KEY_MESSAGE, messageText)
            startActivity(ToolbarActivity.getIntent(this, messageText))
            Toast.makeText(this, "welcome to ToolbarActivityClass!", Toast.LENGTH_SHORT).show()
        }
    }
}