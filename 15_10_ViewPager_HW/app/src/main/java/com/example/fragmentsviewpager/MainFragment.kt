package com.example.fragmentsviewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainFragment : Fragment(R.layout.fragment_main), ArticleFilter {
    private val keyBadges = "Badges"
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val badges = mutableListOf<Int>()
        for (s in 0 until screens.count()) {
            badges.add(screens[s].badgeNum)
        }
        outState.putIntArray(keyBadges, badges.toIntArray())
        outState.putParcelableArray("KEY", currentTags.toTypedArray())
    }

    override fun filterArticles(tags: List<ArticleType>) {
        currentTags = tags
        val newScreens = screens.filter { tags.contains(it.tags) }
        val adapter2 = OnBoardingAdapter(newScreens, this)
        viewPager.adapter = adapter2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tags[position].tag
        }.attach()
        for (s in 0 until currentTags.count()) {
            if (screens[s].badgeNum != 0) {
                tabLayout.getTabAt(s)?.orCreateBadge?.apply {
                    number = screens[s].badgeNum
                    badgeGravity = BadgeDrawable.TOP_END
                }
            }
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.removeBadge()
                screens[position].badgeNum = 0
            }
        })
    }

    private fun setBadge(index: Int, badge: Int) {
        screens[index].badgeNum = badge
    }

    private val screens: List<OnBoardingScreen> = listOf(
        OnBoardingScreen(
            drawableRes = R.drawable.ic_business,
            textRes = R.string.bezos,
            tags = ArticleType.Business,
            badgeNum = 0
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_health,
            textRes = R.string.franklin,
            tags = ArticleType.Health,
            badgeNum = 0
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_sport,
            textRes = R.string.lev,
            tags = ArticleType.Sport,
            badgeNum = 0
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_people,
            textRes = R.string.linkoln,
            tags = ArticleType.People,
            badgeNum = 0
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_technology,
            textRes = R.string.jobs,
            tags = ArticleType.Technologies,
            badgeNum = 0
        ),
        OnBoardingScreen(
            drawableRes = R.drawable.ic_car,
            textRes = R.string.ford,
            tags = ArticleType.Auto,
            badgeNum = 0
        )
    )
    private var currentTags = ArticleType.values().toList()
    private fun showDialog() {
        ConfirmDialogFragment.newInstance(currentTags.toTypedArray())
            .show(childFragmentManager, "confirmDialogTag")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val badges: MutableList<Int>
        articleTypeButton.setOnClickListener {
            showDialog()
        }
        if (savedInstanceState != null) {
            currentTags =
                savedInstanceState.getParcelableArray("KEY")!!.toList() as List<ArticleType>
            badges = savedInstanceState.getIntArray(keyBadges)!!.toMutableList()
            for (i in 0 until screens.count()) {
                screens[i].badgeNum = badges[i]
            }
        }
        filterArticles(currentTags)

        badgeRandomButton.setOnClickListener {
            val randomBadge = Random.nextInt(ArticleType.values().indices)
            requireActivity().tabLayout.getTabAt(randomBadge)?.orCreateBadge?.apply {
                number = Random.nextInt(1..10)
                setBadge(randomBadge, number)
                badgeGravity = BadgeDrawable.TOP_END
            }
        }

        worm_dots_indicator.setViewPager2(viewPager)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.setPageTransformer { page, position ->
            NextPageTransformer().transformPage(page, position)
        }
    }

}

