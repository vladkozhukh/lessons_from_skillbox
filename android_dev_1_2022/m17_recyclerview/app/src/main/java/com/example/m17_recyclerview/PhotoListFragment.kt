package com.example.m17_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import com.example.m17_recyclerview.data.Photo
import com.example.m17_recyclerview.databinding.FragmentPhotoListBinding
import com.example.m17_recyclerview.presentation.MarsAdapter
import com.example.m17_recyclerview.presentation.MarsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PhotoListFragment : Fragment() {

    private var _binding: FragmentPhotoListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MarsViewModel by viewModels()

    private val pagedAdapter = MarsAdapter { item ->
        onItemClick(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhotoListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleView.adapter = pagedAdapter
        viewModel.photos.onEach {
            pagedAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun onItemClick(item: Photo) {
        val action = PhotoListFragmentDirections.actionFirstFragmentToSecondFragment(item.img_src)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}