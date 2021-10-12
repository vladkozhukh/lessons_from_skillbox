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
<<<<<<< HEAD
            "Иван (Мортал) Иванов",
            "https://meragor.com/files/styles//220_220_bottom_wm/_mortal_kombat_0.jpg",
=======
            "Иван Иванов",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.depositphotos.com%2Fstock-photos%2F%25D0%25B4%25D0%25B5%25D0%25BB%25D0%25BE%25D0%25B2%25D0%25BE%25D0%25B9-%25D1%2587%25D0%25B5%25D0%25BB%25D0%25BE%25D0%25B2%25D0%25B5%25D0%25BA-%25D0%25B0%25D0%25B2%25D0%25B0%25D1%2582%25D0%25B0%25D1%2580.html&psig=AOvVaw0KnnDZOB63y5eWAtAQTDCK&ust=1634133631656000&source=images&cd=vfe&ved=2ahUKEwjWgqimhMXzAhVKk6QKHeyGB78QjRx6BAgAEAk",
>>>>>>> origin/main
            Random.nextInt(18..50),
            true
        ),
        User(
<<<<<<< HEAD
            "Валентин (Парк) Петров",
            "https://meragor.com/files/styles//220_220_bottom_wm/fon-kino-38862.jpg",
=======
            "Валентин Петров",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkwork.ru%2Fvector-tracing%2F207103%2Fsdelayu-stilizovannuyu-avatarku-risunok-iz-vashey-fotografii&psig=AOvVaw2EKiRDiUIMntM_Gn3qabu6&ust=1634133645670000&source=images&cd=vfe&ved=2ahUKEwjNrf-shMXzAhWSN-wKHRxvDvUQjRx6BAgAEAk",
>>>>>>> origin/main
            Random.nextInt(18..50),
            false
        ),
        User(
<<<<<<< HEAD
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
=======
            "Константин Сидоров",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.infoniac.ru%2Fnews%2FO-chem-rasskazhet-vasha-avatarka.html&psig=AOvVaw2EKiRDiUIMntM_Gn3qabu6&ust=1634133645670000&source=images&cd=vfe&ved=0CAkQjRxqFwoTCKi1nKWExfMCFQAAAAAdAAAAABAF",
            Random.nextInt(18..50),
            true
        ), User(
            "Алексей Казак",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fdemotivation.ru%2Fphoto%2Ffotografii-lyudej-na-avatarku-60-foto&psig=AOvVaw2EKiRDiUIMntM_Gn3qabu6&ust=1634133645670000&source=images&cd=vfe&ved=0CAkQjRxqFwoTCKi1nKWExfMCFQAAAAAdAAAAABAL",
            Random.nextInt(18..50),
            false
        ), User(
            "Анна Адамович",
            "https://katerynaupit.com/wp-content/uploads/2017/03/%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B0%D0%BD%D0%B4%D1%80%D0%B0-33.jpg",
>>>>>>> origin/main
            Random.nextInt(18..50),
            true
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        initList()
=======
>>>>>>> origin/main
    }

    private fun initList() {
        with(userList) {
            adapter = UserAdapter((users + users).shuffled())
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}