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
            "Иван Иванов",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.depositphotos.com%2Fstock-photos%2F%25D0%25B4%25D0%25B5%25D0%25BB%25D0%25BE%25D0%25B2%25D0%25BE%25D0%25B9-%25D1%2587%25D0%25B5%25D0%25BB%25D0%25BE%25D0%25B2%25D0%25B5%25D0%25BA-%25D0%25B0%25D0%25B2%25D0%25B0%25D1%2582%25D0%25B0%25D1%2580.html&psig=AOvVaw0KnnDZOB63y5eWAtAQTDCK&ust=1634133631656000&source=images&cd=vfe&ved=2ahUKEwjWgqimhMXzAhVKk6QKHeyGB78QjRx6BAgAEAk",
            Random.nextInt(18..50),
            true
        ),
        User(
            "Валентин Петров",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkwork.ru%2Fvector-tracing%2F207103%2Fsdelayu-stilizovannuyu-avatarku-risunok-iz-vashey-fotografii&psig=AOvVaw2EKiRDiUIMntM_Gn3qabu6&ust=1634133645670000&source=images&cd=vfe&ved=2ahUKEwjNrf-shMXzAhWSN-wKHRxvDvUQjRx6BAgAEAk",
            Random.nextInt(18..50),
            false
        ),
        User(
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
            Random.nextInt(18..50),
            true
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initList() {
        with(userList) {
            adapter = UserAdapter((users + users).shuffled())
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}