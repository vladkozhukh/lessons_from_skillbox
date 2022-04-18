package com.example.m9_quiz_localization.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.m9_quiz_localization.R
import com.example.m9_quiz_localization.databinding.FragmentThirdBinding
import com.example.m9_quiz_localization.quiz.Question

private const val ARG_QUESTION_1 = "ARG_QUESTION_1"
private const val ARG_QUESTION_2 = "ARG_QUESTION_2"
private const val ARG_ANSWERS_LIST = "ARG_ANSWERS_LIST"
private lateinit var question1: String
private lateinit var question2: String

class ThirdFragment : Fragment() {
    private var answer1: String = null.toString()
    private var answer2: String = null.toString()
    private var answers: Question =
        Question(answers = listOf(answer1, answer2), question = String(), feedback = listOf())

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getArgument()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListenersButtons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getArgument() {
        arguments?.let {
            answers = it.getParcelable(ARG_ANSWERS_LIST) ?: error("message")
            question1 = it.getString(ARG_QUESTION_1).toString()
            question2 = it.getString(ARG_QUESTION_2).toString()
        }
    }

    private fun setListenersButtons() {
        binding.bToRepeat.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }
        setAnimatedTextViewWithAlphaEffect()
        binding.tvQuestionOne.text = question1
        binding.tvQuestionTwo.text = question2
    }

    private fun setAnimatedTextViewWithAlphaEffect() {
        binding.tvAnswerOne.let {
            it.text = answers.answers[0]
            it.alpha = 0F
        }
        binding.tvAnswerOne.animate().apply {
            duration = 4000
            alpha(1F)
        }
        binding.tvAnswerTwo.let {
            it.text = answers.answers[1]
            it.alpha = 0F
        }
        binding.tvAnswerTwo.animate().apply {
            duration = 4000
            alpha(1F)
        }
    }
}