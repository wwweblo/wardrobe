package com.example.wardrobe_2.Activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.wardrobe_2.com.example.wardrobe_2.data.ClothingItemDatabase
import com.example.wardrobe_2.data.ClothingItem
import com.example.wardrobe_2.databinding.ActivityAddClothesBinding
import kotlinx.coroutines.launch

class AddClothes : AppCompatActivity() {

    private lateinit var binding: ActivityAddClothesBinding
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddClothesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener {
            // Добавьте код для выбора изображения
        }

        binding.button.setOnClickListener {
            saveClothingItem()
        }
    }

    private fun saveClothingItem() {
        val name = binding.editTextName.text.toString()
        val description = binding.editTextTextDescription.text.toString()
        val tags = binding.editTextTextTags.text.toString()
        val imagePath = selectedImageUri?.toString()

        if (name.isNotEmpty() && description.isNotEmpty() && tags.isNotEmpty() && imagePath != null) {
            val clothingItem = ClothingItem(name = name, description = description, tags = listOf(tags), imagePath = imagePath)
            insertClothingItem(clothingItem)
        } else {
            // Обработайте случай, когда какие-то из полей пусты
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertClothingItem(clothingItem: ClothingItem) {
        val dao = ClothingItemDatabase.getInstance(this).clothingItemDao()

        lifecycleScope.launch {
            dao.insert(clothingItem)
            finish() // Закрываем активность после добавления элемента
        }
    }
}
