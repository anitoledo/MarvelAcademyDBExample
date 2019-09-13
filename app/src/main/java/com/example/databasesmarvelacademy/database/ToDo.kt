package com.example.databasesmarvelacademy.database

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_dos")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    var done : Boolean
){
    companion object {
        val diff = object : DiffUtil.ItemCallback<ToDo>() {
            override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem == newItem
        }
    }
}
