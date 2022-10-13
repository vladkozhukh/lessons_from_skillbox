package com.example.m17_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.m17_recyclerview.databinding.FragmentPhotoItemBinding

private const val ARG_PARAM1 = "imageScr"

class PhotoItemFragment : Fragment() {
    private var imageScr: String? = null

    private var _binding: FragmentPhotoItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageScr = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhotoItemBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = imageScr
        Glide.with(view)
            .load(imageView)
            .into(binding.detailImagePhoto)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}