package com.example.kitchen.module15

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.kitchen.R
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity(R.layout.activity_toolbar) {
    private val users = listOf(
        "Cat", "Man", "Dog"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.title = "new toolbar" /* вариант записи */
        toolbar.setTitle(R.string.toolbar) /* правильнее записать будет так */

        val message = intent.getStringExtra(KEY_MESSAGE)
        textFromMessageEditText.text = message

        initToolBar()

    }

    private fun initToolBar() {
        toolbar.setNavigationOnClickListener {

            val toolbarActivityIntent = Intent(
                this,
                CoordinatorActivity::class.java
            )
            startActivity(toolbarActivityIntent)
            toast("Ooh, you back to coordinatorActivityClass again.")
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
                expandTextView.text = getString(R.string.search_expanded)
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                expandTextView.text = getString(R.string.search_collapsed)
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

    companion object {
        private const val KEY_MESSAGE = "message key"

        fun getIntent(context: Context, message: String?): Intent{
            return Intent(context, ToolbarActivity::class.java).putExtra(
                KEY_MESSAGE, message
            )
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}