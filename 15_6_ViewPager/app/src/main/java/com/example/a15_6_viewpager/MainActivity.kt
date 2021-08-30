package com.example.a15_6_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val screens: List<OnBoardingScreen> = listOf(
        OnBoardingScreen(
            textRes = R.string.onboarding_text_1,
            bgColorRes = R.color.onboarding_color_1,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnBoardingScreen(
            textRes = R.string.onboarding_text_2,
            bgColorRes = R.color.onboarding_color_2,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnBoardingScreen(
            textRes = R.string.onboarding_text_3,
            bgColorRes = R.color.onboarding_color_3,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnBoardingScreen(
            textRes = R.string.onboarding_text_4,
            bgColorRes = R.color.onboarding_color_4,
            drawableRes = R.drawable.ic_launcher_background
        ),
        OnBoardingScreen(
            textRes = R.string.onboarding_text_5,
            bgColorRes = R.color.onboarding_color_5,
            drawableRes = R.drawable.ic_launcher_foreground
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = OnBoardingAdapter(screens, this)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1

        // праграммное перелистование (2 страница,если false - скачок, не плавно)
        viewPager.setCurrentItem(2, false)

        // получени текущей позиции страницы
        viewPager.currentItem

        // свойства скролла ориентации перелистования -> горизонтальное
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // callback ViewPager
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            // принимает "position" на которую пользоваетль перелистнул ээкран
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                toast("selected position $position")
            }
        })

        // анимация переключения страниц
        viewPager.setPageTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                when {
                    position < -1 || position > 1 -> { // логика крайних страниц при полном перелистывании
                        page.alpha = 0f
                    }
                    position <= 0 -> {  // логика при свайпе с левой от видимой
                        page.alpha = 1 + position
                    }
                    position <= 1 -> { // логика при свайпе с правой от видимой
                        page.alpha = 1 - position
                    }
                }
            }
        })
    }

}

