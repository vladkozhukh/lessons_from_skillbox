package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lists.adapters.ImageGridAdapter
import kotlinx.android.synthetic.main.fragment_grid_image_list.*

class ImageGridFragment: Fragment(R.layout.fragment_grid_image_list) {

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

    private fun initList() = with(gridImageList){
        adapter = ImageGridAdapter().apply {
            setImages(images + images + images + images)
        }
        setHasFixedSize(true)

        addItemDecoration(ItemOffsetDecoration(requireContext()))

        layoutManager = GridLayoutManager(requireContext(), 3).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                    return if (position % 3 == 0) 2 else 1
                }
            }
        }
    }
}
