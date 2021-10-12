package com.example.fragmentsviewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {
    private val screens: List<OnBoardingScreen> = listOf(
        OnBoardingScreen(
            drawableRes = R.drawable.ic_business,
            textRes = R.string.bezos,
            tags = listOf(ArticleType.Business)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_business,
            textRes = R.string.kapone,
            tags = listOf(ArticleType.Business)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_health,
            textRes = R.string.toro,
            tags = listOf(ArticleType.Health)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_health,
            textRes = R.string.franklin,
            tags = listOf(ArticleType.Health)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_sport,
            textRes = R.string.aristotel,
            tags = listOf(ArticleType.Sport)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_sport,
            textRes = R.string.lev,
            tags = listOf(ArticleType.Sport)
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(screens, this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0,1 -> {
                    tab.text = ArticleType.Business.tag
                }
                2,3 -> {
                    tab.text = ArticleType.Health.tag
                }
                4,5 -> {
                    tab.text = ArticleType.Sport.tag
                }
            }
        }.attach()

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.setPageTransformer { page, position ->
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


}