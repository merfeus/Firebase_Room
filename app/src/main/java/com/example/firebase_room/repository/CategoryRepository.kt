package com.example.firebase_room.repository

import android.content.Context
import com.example.firebase_room.database.AppDataBase
import com.example.firebase_room.database.dao.CategoryDAO
import com.example.firebase_room.model.Category

class CategoryRepository(val context: Context) {

    private val dao: CategoryDAO = AppDataBase.getDataBase(context).categoryDao()

    fun getCategory(): List<Category>{
        return dao.getCategories()
    }

    fun insertCategory(category: Category){
        return dao.insert(arrayListOf(category))
    }

}