package com.example.skillbox_hw_quiz.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.R
import com.example.skillbox_hw_quiz.databinding.FragmentThirdBinding
import com.example.skillbox_hw_quiz.quiz.Question

// 3. Выносить за класс (1) или писать в классе?
private const val ARG_QUESTION_1 = "ARG_QUESTION_1"
private const val ARG_QUESTION_2 = "ARG_QUESTION_2"
private const val ARG_ANSWERS_LIST = "ARG_ANSWERS_LIST"
private lateinit var question1: String
private lateinit var question2: String

class ThirdFragment : Fragment() {
    // 1
    private  var answer1: String = null.toString()
    private  var answer2: String = null.toString()
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
        binding.tvQuestionOne.text = question1
        binding.tvAnswerOne.text = answers.answers[0]
        binding.tvQuestionTwo.text = question2
        binding.tvAnswerTwo.text = answers.answers[1]
    }
}