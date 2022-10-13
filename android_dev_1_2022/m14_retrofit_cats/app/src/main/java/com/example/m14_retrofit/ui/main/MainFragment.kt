package com.example.m14_retrofit.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val loadView = {
            lifecycleScope
                .launchWhenStarted {
                    val response = RetrofitService.searchImageApi.getCatImage()
                    Glide
                        .with(view)
                        .load(response.body()?.first()?.url)
                        .into(binding.imageView)
                }
        }
        loadView.invoke()

        binding.button.setOnClickListener {
            loadView.invoke()
        }
    }
}
