package com.example.m17_recyclerview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m17_recyclerview.data.Photo
import com.example.m17_recyclerview.databinding.PhotoItemCardViewBinding

class MarsAdapter(private val onClick: (Photo) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: List<Photo> = emptyList()
    fun setData(it: List<Photo>) {
        this.data = it
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoHolder(
            PhotoItemCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PhotoHolder -> {
                holder.bind(data[position])
                holder.itemView.setOnClickListener {
                    it.let {
                        onClick(data[position])
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}

class PhotoHolder(private val binding: PhotoItemCardViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
        val image = photo.img_src.replace("http", "https")
        Glide.with(itemView.context)
            .load(image)
            .into(binding.roverImage)
        binding.roverName.text = "Rover: ${photo.rover.name}"
        binding.earthDate.text = "Date: ${photo.earth_date}"
        binding.cameraName.text = "Camera: ${photo.camera.name}"
        binding.sol.text = "Sol: ${photo.sol}"
    }
}