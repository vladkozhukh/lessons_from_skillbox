package com.example.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main), Navigator {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateTo(ListFragment())
    }

    override fun navigateTo(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.containerMainFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

}