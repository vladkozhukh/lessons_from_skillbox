package com.example.m12_mvvm.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m12_mvvm.R
import com.example.m12_mvvm.databinding.MainFragmentBinding
import kotlinx.coroutines.flow.collect

private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    /**
     * [activityViewModels] передача view при смене фрагмента
     */
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startTimer.setOnClickListener {
            viewModel.onClick()
        }
        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.stateFlow.collect {
                    Log.d(TAG, "onViewCreated: $it")
                    binding.theFlow.text = it
                }
            }
        viewModel.liveData.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: $it")
            binding.liveData.text = it
        }

        binding.nextActivity.setOnClickListener {
            parentFragmentManager.beginTransaction()

                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                .replace(R.id.container, MainFragment.newInstance())
                .addToBackStack("")
                .commit()
        }
    }
}