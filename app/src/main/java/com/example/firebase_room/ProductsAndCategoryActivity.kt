package com.example.firebase_room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_room.view.CategoryCrudFragment

class ProductsAndCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_and_category_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, CategoryCrudFragment())
                .commitNow()
        }
    }
}