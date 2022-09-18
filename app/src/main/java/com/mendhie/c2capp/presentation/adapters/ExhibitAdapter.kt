package com.mendhie.c2capp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.mendhie.c2capp.data.models.Exhibit
import com.mendhie.c2capp.databinding.ItemExhibitBinding

class ExhibitAdapter(): RecyclerView.Adapter<ExhibitAdapter.ExhibitViewHolder>() {
    private var exhibits = listOf<Exhibit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitViewHolder {
        val binding = ItemExhibitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExhibitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        //update each exhibit item in recyclerview
        holder.bindView(exhibits[position])
    }

    override fun getItemCount() = exhibits.size

    fun updateExhibits(list: List<Exhibit>){
        exhibits = list
        notifyDataSetChanged()
    }

    inner class ExhibitViewHolder(private val binding: ItemExhibitBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(exhibit: Exhibit){

            binding.txtTitle.text = exhibit.title
            binding.lstExhibits.layoutManager =
                LinearLayoutManager(binding.root.context, HORIZONTAL, false)
            binding.lstExhibits.adapter = ImageAdapter(exhibit.images)
        }
    }
}