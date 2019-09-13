package com.example.databasesmarvelacademy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {

    @Query("SELECT * from to_dos")
    fun getAllTodos() : LiveData<List<ToDo>>

    @Insert
    suspend fun insert(toDo : ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Query("DELETE FROM to_dos")
    suspend fun deleteAll()
}
