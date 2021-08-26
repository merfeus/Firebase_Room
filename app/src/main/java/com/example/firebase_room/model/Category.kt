package com.example.firebase_room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//dps para model
@Entity
data class Category(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cat_id")
    var id: Long = 0,
    @ColumnInfo(name = "cat_name")
    val name: String
)
