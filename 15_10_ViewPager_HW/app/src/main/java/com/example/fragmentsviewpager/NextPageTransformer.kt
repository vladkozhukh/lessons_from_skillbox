package com.example.fragmentsviewpager

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class NextPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        when {
            position < -1 || position > 1 -> {
                page.alpha = 0f
            }
            position <= 0 -> {
                page.alpha = 1 + position
            }
            position <= 1 -> {
                page.alpha = 1 - position
            }
        }
    }
}