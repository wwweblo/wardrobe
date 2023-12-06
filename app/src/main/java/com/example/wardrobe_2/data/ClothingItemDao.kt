package com.example.wardrobe_2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClothingItemDao {

    @Insert
    suspend fun insert(item: ClothingItem)

    @Query("SELECT * FROM clothing_items ORDER BY name")
    fun getAllClothingItems(): LiveData<List<ClothingItem>>

    @Query("SELECT * FROM clothing_items WHERE :tag IN (:tags) ORDER BY name")
    fun getClothingItemsByTag(tag: String, tags: List<String>): LiveData<List<ClothingItem>>

    @Query("SELECT * FROM clothing_items ORDER BY name")
    suspend fun getAllClothingItemsSync(): List<ClothingItem>
}
