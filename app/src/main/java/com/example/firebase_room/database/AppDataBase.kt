package com.example.firebase_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firebase_room.database.dao.CategoryDAO
import com.example.firebase_room.database.dao.ProductDAO
import com.example.firebase_room.model.Category
import com.example.firebase_room.model.Product

//comecar por aqui, dps para model -> Categoria
@Database(
    entities = [Product::class, Category::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDAO
    abstract fun productDao(): ProductDAO

    companion object {
        fun getDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "crudp_app"
            )
                .allowMainThreadQueries()
                .build()
        }
    }


}