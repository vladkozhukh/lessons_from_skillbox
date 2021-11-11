package com.example.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.databinding.ItemLocationMessageBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import kotlinx.android.extensions.LayoutContainer
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import kotlin.random.Random

lateinit var binding: ItemLocationMessageBinding

class DatasetAdapter : ListAdapter<Dataset, DatasetAdapter.Holder>(DatasetDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemLocationMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        return Holder(binding)
        //  parent.inflate(R.layout.item_location_message)
    }

    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    //        val binding = ActivityMainBinding.inflate(LayoutInflater.from(context), parent, false)
    //        return Holder(binding)
    //    }
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

    class Holder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yy")
            .withZone(ZoneId.systemDefault())

        fun bind(dataset: Dataset) {
            dataset.text
            formatter.format(dataset.createdAt)
        }
    }
}