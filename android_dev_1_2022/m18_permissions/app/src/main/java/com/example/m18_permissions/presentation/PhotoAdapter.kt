package com.example.m18_permissions.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.m18_permissions.data.Photo
import com.example.m18_permissions.databinding.PhotoItemCardViewBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    private var data = ArrayList<Photo>()

    class PhotoHolder(private val binding: PhotoItemCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) = with(binding) {
            Glide.with(itemView.context)
                .load(photo.imageId)
                .into(imageIdView)
            earthDate.text = photo.earthData
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(
            PhotoItemCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addPhoto(photo: Photo) {
        data.add(photo)
        notifyDataSetChanged()
    }
}