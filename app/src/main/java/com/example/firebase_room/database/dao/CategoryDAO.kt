package com.example.firebase_room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firebase_room.model.Category
import java.util.*

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getCategories(): List<Category>

    @Insert
    fun insert(list: List<Category>)
}