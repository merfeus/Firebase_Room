package com.example.firebase_room.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import com.example.firebase_room.database.AppDataBase
import com.example.firebase_room.model.Category
import com.example.firebase_room.model.Product
import com.example.firebase_room.model.ProductWithCategory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDAOTest {

    private lateinit var database: AppDataBase
    private lateinit var dao: ProductDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insert_category_returns_true(){
        val c1 = Category(10L, "Eletronico")
        val p1 = Product(20L, "TV", 300.10, c1.id)
        val productWithCategory = ProductWithCategory(prodct = p1, category = c1)

        dao.insert(productWithCategory)

        val results = dao.getProduct()
        Truth.assertThat(results).contains(productWithCategory)
    }
}