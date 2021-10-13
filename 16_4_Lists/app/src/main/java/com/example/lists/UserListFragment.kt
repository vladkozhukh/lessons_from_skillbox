package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_list.*
import kotlin.random.Random
import kotlin.random.nextInt

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private var users = listOf(
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

    // 1.7 сохранение адаптера в поле фрагмента
    private var userAdapter: UserAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        // обработка нажатия на кнопку 1.1
        addFab.setOnClickListener { addUser() }
        // 1.11 вызываем updateUsers при первом отображении списка
        userAdapter?.updateUsers(users)
        // 3.2. прописываем для оповещения изменения списка
        // userAdapter?.notifyDataSetChanged()
        // другой вариант прописать
        userAdapter?.notifyItemRangeChanged(0, users.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        userAdapter = null
    }

    private fun initList() {
        // 1.8 инициализируем userAdapter
        userAdapter =
            UserAdapter { position -> deleteUser(position) } // 2.6 удаление в листе по определенной позиции
        with(userList) {
            adapter = userAdapter // 1.9 -> addUser
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    // 2.5 метод удаления deleteUser
    private fun deleteUser(position: Int) {
        // 2.7 фильтрация списка при нажатии, позиция не ровна позиции на которую нажали
        users = users.filterIndexed { index, user -> index != position }
        // 2.8 переустановим новый список в адаптер
        userAdapter?.updateUsers(users)
        userAdapter?.notifyItemRemoved(position) // 3.4 удаление той позиции на которую нажали
    }

    // 1.2 метод создания addUser
    private fun addUser() {
        // случайный пользователь в первую строку
        val newUser = users.random()
        users = listOf(newUser) + users // далее см. 1.3 см.адаптер
        userAdapter?.updateUsers(users) // 1.10 передаем новый список пользователей
        userAdapter?.notifyItemInserted(0) // 3.3 добавление на первую строку

        userList.scrollToPosition(0) // 3.5 скролинг к добавленой позиции
    }

}