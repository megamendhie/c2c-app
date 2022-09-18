package com.mendhie.c2capp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mendhie.c2capp.databinding.ItemImageBinding

class ImageAdapter(val images: List<String>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class ImageViewHolder(val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(imageUrl: String){
            Glide.with(binding.root.context)
                .load(imageUrl)
                .into(binding.imgIcon)
        }
    }
}