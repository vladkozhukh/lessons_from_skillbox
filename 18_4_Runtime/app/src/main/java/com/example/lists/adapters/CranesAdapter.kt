package com.example.lists.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.lists.Cranes
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CranesAdapter(
    onItemClicked: (position: Int) -> Unit,
) : AsyncListDifferDelegationAdapter<Cranes>(CranesDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(AutoAdapterDelegate(onItemClicked))
            .addDelegate(TowerAdapterDelegate(onItemClicked))
    }

    class CranesDiffUtilCallback : DiffUtil.ItemCallback<Cranes>() {
        override fun areItemsTheSame(oldItem: Cranes, newItem: Cranes): Boolean {
            return when {
                oldItem is Cranes.Tower && newItem is Cranes.Tower -> oldItem.id == newItem.id
                oldItem is Cranes.Auto && newItem is Cranes.Auto -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Cranes, newItem: Cranes): Boolean {
            return oldItem == newItem
        }
    }
}