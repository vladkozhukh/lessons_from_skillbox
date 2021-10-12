package com.example.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private val users = listOf(
        User(
            "Иван (Мортал) Иванов",
            "https://meragor.com/files/styles//220_220_bottom_wm/_mortal_kombat_0.jpg",
            Random.nextInt(18..50),
            true
        ),
        User(
            "Валентин (Парк) Петров",
            "https://meragor.com/files/styles//220_220_bottom_wm/fon-kino-38862.jpg",
            Random.nextInt(18..50),
            false
        ),
        User(
            "Константин (Супермен) Сидоров",
            "https://meragor.com/files/styles//220_220_bottom_wm/kino-logotipy-upermen_superman-14469.jpg",
            Random.nextInt(18..50),
            true
        ), User(
            "Алексей (Адидас) Казак",
            "https://meragor.com/files/styles//220_220_bottom_wm/adidas_adidas-fon-logotipy-sport-19041.jpg",
            Random.nextInt(18..50),
            false
        ), User(
            "Анна (Капитан) Адамович",
            "https://meragor.com/files/styles//220_220_bottom_wm/apitan_merika_captain_america-kino-19086.jpg",
       Random.nextInt(18..50),
            true
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
    }

    private fun initList() {
        with(userList) {
            adapter = UserAdapter((users + users).shuffled())
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}