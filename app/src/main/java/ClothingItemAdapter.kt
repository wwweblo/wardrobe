package com.example.wardrobe_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wardrobe_2.data.ClothingItem
import com.example.wardrobe_2.databinding.ItemClothingBinding

class ClothingItemAdapter : ListAdapter<ClothingItem, ClothingItemAdapter.ClothingItemViewHolder>(ClothingItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingItemViewHolder {
        val binding = ItemClothingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClothingItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ClothingItemViewHolder(private val binding: ItemClothingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClothingItem) {
            binding.textViewName.text = item.name
            // Добавьте другие поля, если необходимо
        }
    }
}

class ClothingItemDiffCallback : DiffUtil.ItemCallback<ClothingItem>() {
    override fun areItemsTheSame(oldItem: ClothingItem, newItem: ClothingItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ClothingItem, newItem: ClothingItem): Boolean {
        return oldItem == newItem
    }
}
