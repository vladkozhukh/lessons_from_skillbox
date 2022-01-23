package com.example.kitchen.module15

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity() {
    private val users = listOf(
        "Cat", "Man", "Dog"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        toolbar.setTitle(R.string.toolbar) /*правильнее записать будет так*/
        toolbar.title = "new toolbar" /*второй вариант записи*/
        initToolBar()

    }

    private fun initToolBar() {
        toolbar.setNavigationOnClickListener {
            toast("Назад")
        }

        toolbar.setOnMenuItemClickListener { it ->
            when (it.itemId) {
                R.id.moviesId -> {
                    toast("Фильмы")
                    true
                }
                R.id.serialsId -> {
                    toast("Сериалы")
                    true
                }
                R.id.action_search -> {
                    toast("Поиск")
                    true
                }
                else -> false
            }
        }

        val searchItem = toolbar.menu.findItem(R.id.action_search)
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                expandTextView.text = "search expanded"
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                expandTextView.text = "search collapsed"
                return true
            }

        })

        val resultSearch = searchItem.actionView as SearchView
        resultSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // поиск на клавиатуре окончательный как написал
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            // поиск на клавиатуре в процессе письма
            override fun onQueryTextChange(newText: String?): Boolean {
                users.filter { it.contains(other = newText ?: "", ignoreCase = true) }
                    .joinToString()
                    .let {
                        searchResultTextView.text = it
                    }
                return true
            }

        })
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}