package com.example.m9_quiz_localization.navigation


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.m9_quiz_localization.R
import com.example.m9_quiz_localization.databinding.ActivityNavigationBinding
import com.example.m9_quiz_localization.quiz.QuizStorage
import java.util.*

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_navigation) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_language -> {
            openLanguageDialog()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    var currentPosition = 0
    private fun openLanguageDialog() {
        val list = arrayOf("English", "Русский")
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Choose language")
        alertBuilder.setSingleChoiceItems(
            list, currentPosition
        ) { _, which -> currentPosition = which }
        alertBuilder.setPositiveButton(
            "Apply"
        ) { dialog, _ ->
            if (currentPosition == 0) {
                setLocale("en", "US")
            } else {
                setLocale("ru", "RU")
            }
            dialog?.dismiss()
        }
        alertBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertBuilder.create()
        alertBuilder.show()
    }

    private fun setLocale(language: String, country: String?) {
        val locale = Locale.forLanguageTag("$language-$country")
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}