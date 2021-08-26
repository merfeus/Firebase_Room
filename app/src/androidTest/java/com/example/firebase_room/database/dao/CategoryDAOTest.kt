package com.example.firebase_room.database.dao

import androidx.room.Room

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.firebase_room.database.AppDataBase
import com.google.common.truth.Truth.assertThat
import com.example.firebase_room.model.Category
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class CategoryDAOTest {

    private lateinit var database: AppDataBase
    private lateinit var dao: CategoryDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.categoryDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insert_category_returns_true() {
        val category1 = Category(1L, "Eletronico")
        val category2 = Category(2L, "Higiene")
        val category3 = Category(3L, "Bazar")
        val listToInsert = arrayListOf(category1, category2, category3)
        dao.insert(listToInsert)



        Category(name = "aaaaaa")

        val results = dao.getCategories()
        assertThat(results).containsExactlyElementsIn(listToInsert)
    }

}