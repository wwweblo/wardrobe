package com.example.wardrobe_2.com.example.wardrobe_2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wardrobe_2.Converters
import com.example.wardrobe_2.data.ClothingItem
import com.example.wardrobe_2.data.ClothingItemDao

@Database(entities = [ClothingItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ClothingItemDatabase : RoomDatabase() {
    abstract fun clothingItemDao(): ClothingItemDao

    companion object {
        private var INSTANCE: ClothingItemDatabase? = null

        fun getInstance(context: Context): ClothingItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClothingItemDatabase::class.java,
                    "clothing_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
