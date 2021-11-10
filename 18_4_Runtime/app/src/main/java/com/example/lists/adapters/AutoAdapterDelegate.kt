package com.example.lists.adapters

import android.view.View
import android.view.ViewGroup
import com.example.lists.Cranes
import com.example.lists.R
import com.example.lists.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class AutoAdapterDelegate(private var onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<Cranes.Auto, Cranes, AutoAdapterDelegate.AutoHolder>() {

    override fun isForViewType(item: Cranes, items: MutableList<Cranes>, position: Int): Boolean {
        return item is Cranes.Auto
    }

    override fun onCreateViewHolder(parent: ViewGroup): AutoHolder {
        return AutoHolder(parent.inflate(R.layout.item_autocrane), onItemClicked)
    }

    override fun onBindViewHolder(
        item: Cranes.Auto,
        holder: AutoHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class AutoHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BaseCranesHolder(view, onItemClicked) {
        fun bind(cranes: Cranes.Auto) {
            bindMainInfo(cranes.name, cranes.avatarLink, cranes.jib, cranes.lifting)
        }
    }


}