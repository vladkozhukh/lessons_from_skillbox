package com.example.a15_2_viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity(R.layout.activity_tabs) {
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
        val adapter = OnBoardingAdapter(screens+screens, this)
        viewPagerTab.adapter = adapter // установка адаптера для viewPager

        // класс для связки tab и viewPager
        TabLayoutMediator(tabLayout, viewPagerTab){
            // Отображени человеческого счета: "Tab ${position+1}"
            tab, position -> tab.text = "Tab ${position+1}" // передача текста в tabs
            if (position %2 == 0){
                tab.setIcon(R.drawable.ic_launcher_foreground) // передача картинки в tabs
            }
        }.attach() // attach связывает tabs & viewPager

        tabLayout.getTabAt(1)?.orCreateBadge?.apply {
            number = 2 // уведомление 2 шт
            badgeGravity = BadgeDrawable.TOP_END // расположение бейджа вверх_лево
        }
        viewPagerTab.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.removeBadge()
            }
        })
    }
}