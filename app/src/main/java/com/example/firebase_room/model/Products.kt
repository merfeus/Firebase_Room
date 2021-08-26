package com.example.firebase_room.model

import androidx.room.*

//SEGUNDA TEBELA
@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "prod_id")
    val id: Long,
    @ColumnInfo(name = "prod_name")
    val name: String,
    @ColumnInfo(name = "prod_price")
    val price: Double,

    val categoryFK: Long
)

data class ProductWithCategory(
    @Embedded//chamando ambas as tabelas como visao
    val prodct: Product?,
    @Relation(parentColumn = "categoryFK", entityColumn = "cat_id")
    val category: Category?
)//criado para juncao com a tabela de product

