package com.example.firebase_room.database.dao

import androidx.room.*
import com.example.firebase_room.model.Category
import java.util.*

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getCategories(): List<Category>

    @Insert
    fun insert(list: List<Category>)

    @Delete
    fun delete(category: Category)

    @Update
    fun update(category: Category)
}