package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateTo(LoginFragment())
    }

    override fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val mainFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (mainFragment != null) {
            val count = mainFragment.childFragmentManager.backStackEntryCount
            if (count > 1) {
                mainFragment.childFragmentManager.popBackStack()
                return
            }
        }
        super.onBackPressed()
    }
}


