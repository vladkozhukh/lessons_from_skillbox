package com.example.m16_architecture.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m16_architecture.databinding.MainFragmentBinding
import com.example.m16_architecture.di.DaggerAppComponent

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }


    private val viewModel: MainViewModel by viewModels {
        DaggerAppComponent.create().mainViewModelFactory()
    }
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.state
                    .collect { state ->
                        when (state) {
                            State.Loading -> {
                                binding.bReload.isEnabled = false
                            }
                            is State.Success -> {
                                lifecycleScope
                                    .launchWhenStarted {
                                        binding.textViewInfo.text = state.message
                                    }
                                binding.bReload.isEnabled = true
                            }
                        }
                    }
            }
        binding.bReload.setOnClickListener {
            viewModel.reloadUsefulActivity()
        }
    }
}
