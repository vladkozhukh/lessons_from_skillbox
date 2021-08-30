package com.example.a15_6_viewpager

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingScreen(
    @StringRes val textRes: Int,
    @ColorRes val bgColorRes: Int,
    @DrawableRes val drawableRes: Int
)
