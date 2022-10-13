package com.example.m12_mvvm.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m12_mvvm.R
import com.example.m12_mvvm.databinding.MainFragmentBinding
import kotlinx.coroutines.flow.collect

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSearch.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            viewModel.onSearchClick(inputText)
        }

        binding.inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.bSearch.isEnabled = s?.let { it.isNotEmpty() && it.length > 3 } ?: false
            }
        })

        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.state
                    .collect { state ->
                        when (state) {
                            State.Loading -> {
                                binding.progressBar.isVisible = true
                                binding.inputTextLayout.error = null
                                binding.bSearch.isEnabled = false
                            }
                            is State.Success -> {
                                binding.progressBar.isVisible = false
                                binding.inputTextLayout.error = null
                                binding.textView.text = state.message
                            }
                        }
                    }
            }
    }
}
