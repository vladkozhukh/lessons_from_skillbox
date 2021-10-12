package com.example.fragmentsviewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_onboarding.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val screens: List<OnBoardingScreen> = listOf(
        OnBoardingScreen(
            drawableRes = R.drawable.ic_business,
            textRes = R.string.bezos,
            tags = listOf(ArticleType.Business)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_health,
            textRes = R.string.franklin,
            tags = listOf(ArticleType.Health)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_sport,
            textRes = R.string.lev,
            tags = listOf(ArticleType.Sport)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_people,
            textRes = R.string.linkoln,
            tags = listOf(ArticleType.People)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_technology,
            textRes = R.string.jobs,
            tags = listOf(ArticleType.Technologies)
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_car,
            textRes = R.string.ford,
            tags = listOf(ArticleType.Auto)
        ),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(screens, this)
        viewPager.adapter = adapter
//        val springDotsIndicator = R.id.spring_dots_indicator as WormDotsIndicator
//        val viewPager2 = R.id.viewPager as ViewPager
//        springDotsIndicator.setViewPager(viewPager2)



        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = ArticleType.Business.tag
                }
                1 -> {
                    tab.text = ArticleType.Health.tag
                }
                2 -> {
                    tab.text = ArticleType.Sport.tag
                }
                3 -> {
                    tab.text = ArticleType.People.tag
                }
                4 -> {
                    tab.text = ArticleType.Technologies.tag
                }
                5 -> {
                    tab.text = ArticleType.Auto.tag
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