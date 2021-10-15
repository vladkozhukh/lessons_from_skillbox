package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_list.*
import kotlin.random.Random
import kotlin.random.nextInt

class PersonListFragment : Fragment(R.layout.fragment_user_list) {

    private var persons = listOf(
        Person.Developer(
            "Иван (Мортал) Иванов",
            "https://meragor.com/files/styles//220_220_bottom_wm/_mortal_kombat_0.jpg",
            Random.nextInt(18..50),
            "Java"
        ),
        Person.User(
            "Валентин (Парк) Петров",
            "https://meragor.com/files/styles//220_220_bottom_wm/fon-kino-38862.jpg",
            Random.nextInt(18..50)
        ),
        Person.Developer(
            "Константин (Супермен) Сидоров",
            "https://meragor.com/files/styles//220_220_bottom_wm/kino-logotipy-upermen_superman-14469.jpg",
            Random.nextInt(18..50),
            "Kotlin"
        ),
        Person.User(
            "Алексей (Адидас) Казак",
            "https://meragor.com/files/styles//220_220_bottom_wm/adidas_adidas-fon-logotipy-sport-19041.jpg",
            Random.nextInt(18..50)
        ),
        Person.User(
            "Анна (Капитан) Адамович",
            "https://meragor.com/files/styles//220_220_bottom_wm/apitan_merika_captain_america-kino-19086.jpg",
            Random.nextInt(18..50)
        )
    )

    // 1.7 сохранение адаптера в поле фрагмента
    private var personAdapter: PersonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        // обработка нажатия на кнопку 1.1
        addFab.setOnClickListener { addPerson() }
        // 1.11 вызываем updateUsers при первом отображении списка
        personAdapter?.updatePersons(persons)
        // 3.2. прописываем для оповещения изменения списка
        // userAdapter?.notifyDataSetChanged()
        // другой вариант прописать
        personAdapter?.notifyItemRangeChanged(0, persons.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        personAdapter = null
    }

    private fun initList() {
        // 1.8 инициализируем userAdapter
        personAdapter =
            PersonAdapter { position -> deletePerson(position) } // 2.6 удаление в листе по определенной позиции
        with(userList) {
            adapter = personAdapter // 1.9 -> addUser
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    // 2.5 метод удаления deleteUser
    private fun deletePerson(position: Int) {
        // 2.7 фильтрация списка при нажатии, позиция не ровна позиции на которую нажали
        persons = persons.filterIndexed { index, user -> index != position }
        // 2.8 переустановим новый список в адаптер
        personAdapter?.updatePersons(persons)
        personAdapter?.notifyItemRemoved(position) // 3.4 удаление той позиции на которую нажали
    }

    // 1.2 метод создания addUser
    private fun addPerson() {
        // случайный пользователь в первую строку
        val newUser = persons.random()
        persons = listOf(newUser) + persons // далее см. 1.3 см.адаптер
        personAdapter?.updatePersons(persons) // 1.10 передаем новый список пользователей
        personAdapter?.notifyItemInserted(0) // 3.3 добавление на первую строку

        userList.scrollToPosition(0) // 3.5 скролинг к добавленой позиции
    }

}