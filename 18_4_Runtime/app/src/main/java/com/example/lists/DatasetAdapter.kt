package com.example.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.databinding.ItemLocationMessageBinding
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

class DatasetAdapter : ListAdapter<Dataset, DatasetAdapter.Holder>(DatasetDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemLocationMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class DatasetDiffUtilCallback : DiffUtil.ItemCallback<Dataset>() {
        override fun areItemsTheSame(oldItem: Dataset, newItem: Dataset): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Dataset, newItem: Dataset): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(private val binding: ItemLocationMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yy")
            .withZone(ZoneId.systemDefault())


        fun bind(dataset: Dataset) {
            binding.messageTextView.text = dataset.text
            binding.createdAtText.text = formatter.format(dataset.createdAt)
        }
    }

// https://www.valueof.io/blog/android-view-binding

}