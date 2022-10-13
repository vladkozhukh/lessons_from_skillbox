package com.example.m14_retrofit.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.m14_retrofit.R
import com.example.m14_retrofit.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateView(view)
        binding.bReload.setOnClickListener {
            updateView(view)
        }
    }

    private fun updateView(view: View) {
        lifecycleScope
            .launchWhenStarted {
                val response = RetrofitService.searchImageApi.getUserImage()
                val textGender = response.body()?.results?.first()?.gender
                val textName = response.body()?.results?.first()?.name
                binding.textViewInfo.text = """
                    Gender: $textGender
                    Name: ${textName?.first} ${textName?.last}
                """.trimIndent()

                val imageViewPicture = response.body()?.results?.first()?.picture?.large
                Glide
                    .with(view)
                    .load(imageViewPicture)
                    .placeholder(R.drawable.ic_no_image)
                    .into(binding.imageView)
            }
    }
}
