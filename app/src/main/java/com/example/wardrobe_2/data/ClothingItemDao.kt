package com.example.wardrobe_2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable

@Dao
interface ClothingItemDao {

    @Insert
    fun insert(item: ClothingItem): Completable

    @Query("SELECT * FROM clothing_items ORDER BY name")
    fun getAllClothingItems(): LiveData<List<ClothingItem>>

    @Query("SELECT * FROM clothing_items WHERE :tag IN (:tags) ORDER BY name")
    fun getClothingItemsByTag(tag: String, tags: List<String>): LiveData<List<ClothingItem>>
}




