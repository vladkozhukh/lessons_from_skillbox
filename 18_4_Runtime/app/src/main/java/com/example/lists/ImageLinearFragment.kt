package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lists.adapters.ImageAdapter
import kotlinx.android.synthetic.main.fragment_linear_image_list.*

class ImageLinearFragment : Fragment(R.layout.fragment_linear_image_list) {

    private val images = listOf(
        "https://source.unsplash.com/random/800x600?flowers",
        "https://source.unsplash.com/random/800x600?mountains",
        "https://source.unsplash.com/random/800x600?city",
        "https://source.unsplash.com/random/800x600?people",
        "https://source.unsplash.com/random/800x600?space",
        "https://source.unsplash.com/random/800x600?animals"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    private fun initList() = with(linearImageList) {
        adapter = ImageAdapter().apply {
            setImages(images + images + images + images)
        }
        setHasFixedSize(true)

        // п.4 собственный разделитель
        val dividerItemDecorationVertical =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val dividerItemDecorationHorizontal =
            DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)
        addItemDecoration(dividerItemDecorationVertical)
        addItemDecoration(dividerItemDecorationHorizontal)

        layoutManager = LinearLayoutManager(requireContext()).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
    }
}
