package com.example.a15_2_viewpager

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnBoardingFragment:Fragment(R.layout.fragment_onboarding) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().setBackgroundResource(requireArguments().getInt(KEY_COLOR))
        textView.setText(requireArguments().getInt(KEY_TEXT))
        imageView.setImageResource(requireArguments().getInt(KEY_IMAGE))
    }

    companion object{
        private const val KEY_TEXT = "text"
        private const val KEY_COLOR = "color"
        private const val KEY_IMAGE = "image"

        fun newInstance(
            @StringRes textRes: Int,
            @ColorRes bgColorRes: Int,
            @DrawableRes drawableRes: Int
        ): OnBoardingFragment{
            return OnBoardingFragment().withArguments {
                putInt(KEY_TEXT, textRes)
                putInt(KEY_COLOR, bgColorRes)
                putInt(KEY_IMAGE, drawableRes)
            }
        }
    }
}