package com.example.lists.adapters

import android.view.View
import android.view.ViewGroup
import com.example.lists.Cranes
import com.example.lists.R
import com.example.lists.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class TowerAdapterDelegate(private var onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<Cranes.Tower, Cranes, TowerAdapterDelegate.TowerHolder>() {

    override fun isForViewType(item: Cranes, items: MutableList<Cranes>, position: Int): Boolean {
        return item is Cranes.Tower
    }

    override fun onCreateViewHolder(parent: ViewGroup): TowerHolder {
        return TowerHolder(parent.inflate(R.layout.item_towercrane), onItemClicked)
    }

    override fun onBindViewHolder(
        item: Cranes.Tower,
        holder: TowerHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class TowerHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BaseCranesHolder(view, onItemClicked) {

        fun bind(cranes: Cranes.Tower) {
            bindMainInfo(cranes.name, cranes.avatarLink, cranes.jib, cranes.lifting)
        }
    }


}