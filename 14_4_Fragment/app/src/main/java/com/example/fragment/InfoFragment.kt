package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class InfoFragment : AppCompatActivity(R.layout.fragment_info), FragmentNavigator {
    override fun toFragmentNavigator(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,Login)
    }
}