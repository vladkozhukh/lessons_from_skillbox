package com.example.a15_6_viewpager

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


// диалог фрагмент который стоит только создать но НЕ отображать (.show - удалить)
// заменить this -> requireActivity()

class ConfirmationDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Delete item")
            .setMessage("Are you sure?")
            .setPositiveButton("Ok", { _, _ ->  })
            .setNegativeButton("No", { _, _ ->  })
            .setNeutralButton("Neutral", { _, _ ->  })
            .create()
    }
}