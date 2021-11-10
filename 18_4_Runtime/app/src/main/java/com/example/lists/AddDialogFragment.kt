package com.example.lists


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.lists.databinding.FragmentDialogBinding
import kotlin.random.Random

class AddDialogFragment : DialogFragment(R.layout.fragment_dialog) {
    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentDialogBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireActivity())
            .setTitle("Новый кран:")
            .setView(binding.root)
            .setPositiveButton("Добавить") { _, _ ->
                (parentFragment as ListFragment).checkedTower = binding.check.isChecked
                (parentFragment as ListFragment).addItem(
                    id = Random.nextLong(),
                    avatarLink = "${R.drawable.ic_image}",
                    name = binding.nameTextView.text.toString(),
                    jib = binding.jibTextView.text.toString(),
                    lifting = binding.liftingTextView.text.toString()
                )
            }
            .setNegativeButton("Отменить") { _, _ -> dismiss() }
            .create()
    }

}


