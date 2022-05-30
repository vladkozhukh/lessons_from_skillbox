package com.example.m12_mvvm.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m12_mvvm.databinding.MainFragmentBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    /**
     * добалвение [MainViewModelFactory] в делегат [viewModels]
     */
    private val viewModel: MainViewModel by viewModels {MainViewModelFactory()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val login = binding.login.text.toString()
            val password = binding.password.text.toString()
            viewModel.onSignClick(login, password)
        }
        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.state
                    .collect { state ->
                        when (state) {
                            is State.Error -> {
                                binding.progressBar.isVisible = false
                                binding.loginLayout.error = state.loginError
                                binding.passwordLayout.error = state.passwordError
                            }
                            State.Loading -> {
                                binding.progressBar.isVisible = true
                                binding.loginLayout.error = null
                                binding.passwordLayout.error = null
                                binding.button.isEnabled = false
                            }
                            State.Success -> {
                                binding.progressBar.isVisible = false
                                binding.loginLayout.error = null
                                binding.passwordLayout.error = null
                                binding.button.isEnabled = true
                            }
                        }
                    }
            }
        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.error
                    .collect { message ->
                        Snackbar.make(
                            requireView(),
                            message,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
            }
    }
}