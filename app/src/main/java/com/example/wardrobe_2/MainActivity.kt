package com.example.wardrobe_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wardrobe_2.Activity.AddClothes
import com.example.wardrobe_2.com.example.wardrobe_2.data.ClothingItemDatabase
import com.example.wardrobe_2.data.ClothingItem
import com.example.wardrobe_2.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ClothingItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ClothingItemAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fabAddClothes.setOnClickListener {
            startActivity(Intent(this, AddClothes::class.java))
        }

        // Загрузка данных из базы данных
        val dao = ClothingItemDatabase.getInstance(this).clothingItemDao()

        // Наблюдение за LiveData
        dao.getAllClothingItems().observe(this, { clothingItems ->
            // Обновление RecyclerView адаптера
            adapter.submitList(clothingItems)
        })
    }
}

