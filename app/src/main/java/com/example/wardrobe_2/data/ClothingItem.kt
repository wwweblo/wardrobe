package com.example.wardrobe_2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothing_items")
data class ClothingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val tags: List<String>,
    val description: String,
    val imagePath: String // Путь к изображению (может быть URL или путь в локальном хранилище)
)
