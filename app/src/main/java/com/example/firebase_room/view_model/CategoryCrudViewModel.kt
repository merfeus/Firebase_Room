package com.example.firebase_room.view_model


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebase_room.database.AppDataBase
import com.example.firebase_room.database.dao.CategoryDAO
import com.example.firebase_room.model.Category

class CategoryCrudViewModel : ViewModel() {

    private val _CATEGORY = MutableLiveData<List<Category>>()
    val category : LiveData<List<Category>> = _CATEGORY

    private lateinit var dao: CategoryDAO

    fun injectContextAndStartDAO(context: Context) {
        dao = AppDataBase.getDataBase(context).categoryDao()
    }

    fun getCategories(){
        _CATEGORY.value = dao.getCategories()
    }

    fun inserCategory(category: Category){
        dao.insert(arrayListOf(category))
        getCategories()
    }

    fun updateCategory(category: Category){
        dao.update(category)
        getCategories()
    }

    fun deletCategory(category: Category){
        dao.delete(category)
        getCategories()
    }

}