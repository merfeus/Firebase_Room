package com.example.firebase_room.repository

import android.content.Context
import com.example.firebase_room.database.AppDataBase
import com.example.firebase_room.database.dao.ProductDAO
import com.example.firebase_room.model.ProductWithCategory

class ProductRepository(context: Context) {

    private val dao : ProductDAO = AppDataBase.getDataBase(context).productDao()

    fun getProduct(): List<ProductWithCategory>{
        return dao.getProduct()
    }

    fun insertProduct(productWithCategory: ProductWithCategory){
//        return dao.insert()
    }
}