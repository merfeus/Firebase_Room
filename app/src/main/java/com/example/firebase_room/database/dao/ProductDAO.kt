package com.example.firebase_room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.firebase_room.model.Category
import com.example.firebase_room.model.Product
import com.example.firebase_room.model.ProductWithCategory

@Dao
interface ProductDAO {

    @Transaction
    @Query("SELECT * FROM Product")
    fun getProduct(): List<ProductWithCategory>

    @Insert
    fun insert(product: Product)

    @Insert
    fun insert(category: Category): Long

    fun insert(productWithCategory: ProductWithCategory){
        insert(productWithCategory.category!!)
        productWithCategory.prodct?.let {
            insert(it)
        }
    }

}