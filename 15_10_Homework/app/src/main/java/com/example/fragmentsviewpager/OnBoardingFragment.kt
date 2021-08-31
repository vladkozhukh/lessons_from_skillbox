package com.example.fragmentsviewpager

import android.nfc.Tag
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnBoardingFragment : Fragment(R.layout.fragment_onboarding) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView.setImageResource(requireArguments().getInt(KEY_IMAGE))
        textView.setText(requireArguments().getInt(KEY_TEXT))
    }

    companion object {
        private const val KEY_IMAGE = "image"
        private const val KEY_TEXT = "text"

        fun newInstance(
            @DrawableRes drawableRes: Int,
            @StringRes textRes: Int,
        ): OnBoardingFragment {
            return OnBoardingFragment().withArguments {
                putInt(KEY_IMAGE, drawableRes)
                putInt(KEY_TEXT, textRes)
            }
        }
    }
}