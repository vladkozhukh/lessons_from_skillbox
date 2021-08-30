package com.example.a15_6_viewpager

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity(R.layout.activity_dialog) {
    // см. строку 69
    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showSimpleDialogButton.setOnClickListener {
            showSimpleDialog()
        }

        showButtonDialogButton.setOnClickListener {
            showDialogWithButtons()
        }

        showSingleChoiceDialogButton.setOnClickListener {
            showDialogWithSingleChoice()
        }

        showCustomLayoutDialogButton.setOnClickListener {
            showDialogWithCustomLayout()
        }

        showDialogFragment.setOnClickListener {
            showDialogFragment()
        }
        showButtonDialogButton.setOnClickListener { showBottomSheetDialog() }
    }

    // обчный диалог
    private fun showSimpleDialog() {
        // паттерн свойства диалога: Builder (контекст)
        val dialog = AlertDialog.Builder(this)
            .setTitle("SimpleDialog")
            .setMessage("SimpleDialogMessage")
            // создание диалога
            .create()
// запуск отображения в эмуляторе
        dialog.show()
    }

    // диалог выбора да/нет детали
    private fun showDialogWithButtons() {
        AlertDialog.Builder(this)
            .setTitle("Delete item")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _, _ -> toast("Clicked yes") }
            .setNegativeButton("No") { _, _ -> toast("Clicked no") }
            .setNeutralButton("Details") { _, _ -> toast("Clicked details") }
            .create()
            .show()
    }

    // диалог выбора открытия
    private fun showDialogWithSingleChoice() {
        // массив элементов выбора
        val mailProviders = arrayOf("google", "yandex", "mailru", "rambler")
        AlertDialog.Builder(this)
            .setTitle("Select mail provider")
            // (переменная val) {_, выбор -> отображение элемента [по индексу]}
            .setItems(mailProviders) { _, which -> toast("Selected = ${mailProviders[which]}") }
            .show()
    }

    // диалог отображения c view
    private fun showDialogWithCustomLayout() {
        dialog = AlertDialog.Builder(this)
            .setView(R.layout.dialog_attention)
            .setPositiveButton("Ok") { _, _ -> }
            .show()
    }
// чтобы не было ошибок в логе при переворте экрана и диалога стр. 10 + 67..73
    override fun onDestroy() {
        super.onDestroy()
        dialog?.dismiss()
    }

    // диалог фрагмента
    private fun showDialogFragment() {
        ConfirmationDialogFragment()
            .show(supportFragmentManager, "confirmationDialogTag")
    }

    private fun hideDialog() {
        supportFragmentManager.findFragmentByTag("confirmationDialogTag")
            ?.let { it as? ConfirmationDialogFragment }
            ?.dismiss()
    }

    private fun showBottomSheetDialog() {
        AvatarDialogFragment().show(supportFragmentManager, "tag")
    }
}