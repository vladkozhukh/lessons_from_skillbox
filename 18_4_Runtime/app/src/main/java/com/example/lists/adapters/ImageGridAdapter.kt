package com.example.lists.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lists.R
import com.example.lists.databinding.ItemGridImageBinding

class ImageGridAdapter : RecyclerView.Adapter<ImageGridAdapter.ViewHolder>() {

    private var images: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemGridBinding =
            ItemGridImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemGridBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    @SuppressLint("NotifyDataSetChanged")
    fun setImages(newImages: List<String>) {
        images = newImages
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemGridImageBinding: ItemGridImageBinding) :
        RecyclerView.ViewHolder(itemGridImageBinding.root) {
        fun bind(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .placeholder(R.drawable.ic_image)
                .into(itemGridImageBinding.gridImageView)
        }
    }
}