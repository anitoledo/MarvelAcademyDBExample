package com.example.databasesmarvelacademy.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Create your To Do Entity
 */
@Entity(tableName = "to_dos")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    var done : Boolean
)
