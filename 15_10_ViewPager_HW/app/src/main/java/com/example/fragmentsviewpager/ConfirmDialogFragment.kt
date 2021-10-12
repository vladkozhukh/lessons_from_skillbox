package com.example.fragmentsviewpager

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val currentTags = arguments?.getParcelableArray(KEY_TAGS)!!.toList()
        val articleFilter = ArticleType.values()

        val checkedArticleType = BooleanArray(articleFilter.count())
        articleFilter.forEachIndexed{ index, it -> checkedArticleType[index] = currentTags.contains(it) }

        return AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.type_article_button))

            .setMultiChoiceItems(
                articleFilter.map { it.tag }.toTypedArray(),
                checkedArticleType
            ) { _, which, isChecked ->
                checkedArticleType[which] = isChecked
            }
            .setPositiveButton(getString(R.string.Yes)) { _, _ ->
                (parentFragment as ArticleFilter).filterArticles(articleFilter
                    .filterIndexed{ index, _ -> checkedArticleType[index] })
            }
            .setNegativeButton(getString(R.string.No)) { _, _ -> }
            .create()
    }

    companion object {
        private const val KEY_TAGS = "image"

        fun newInstance(
            tags: Array<ArticleType>,
        ): ConfirmDialogFragment {
            return ConfirmDialogFragment().withArguments {
                putParcelableArray(KEY_TAGS, tags)
            }
        }
    }
}