package com.example.databasesmarvelacademy.database

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_dos")
data class ToDoSolution(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    var done : Boolean
)
