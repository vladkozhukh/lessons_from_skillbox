package com.example.fragmentsviewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(
    private val screens: List<OnBoardingScreen>, activity: MainFragment
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return screens.size
    }

    override fun createFragment(position: Int): Fragment {
        val screen: OnBoardingScreen = screens[position]
        return OnBoardingFragment.newInstance(
            textRes = screen.textRes,
            drawableRes = screen.drawableRes
        )
    }
}