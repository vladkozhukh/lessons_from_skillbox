package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment(R.layout.fragment_info) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
   //     val textView = requireView().findViewById<TextView>(R.id.inputTextView)
        inputTextView.text = requireArguments().getString(KEY_TEXT)
    }

    companion object {
        private const val KEY_TEXT = "key_text"
        fun newInstance(text: String): InfoFragment {
            return InfoFragment().withArguments{
                putString(KEY_TEXT, text)
            }
//            val fragment = InfoFragment().withArguments()
//            val args = Bundle().apply {
//                putString(KEY_TEXT, text)
//            }
//            fragment.arguments = args
//            return fragment
        }
    }
}