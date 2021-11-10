package com.example.lists.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lists.R

abstract class BaseCranesHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val jibTextView: TextView = view.findViewById(R.id.jibTextView)
        private val liftingTextView: TextView = view.findViewById(R.id.liftingTextView)

        init {
            view.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        @SuppressLint("SetTextI18n")
        protected fun bindMainInfo(
            name: String,
            avatarLink: String,
            jib: String,
            lifting: String,
        ) {
            nameTextView.text = name
            jibTextView.text = "Стрела, max: $jib м."
            liftingTextView.text = "Грузоподъемность: $lifting т."

            Glide.with(itemView)
                .load(avatarLink)
                .placeholder(R.drawable.ic_image)
                .into(avatarImageView)

        }
    }