package com.example.databasesmarvelacademy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasesmarvelacademy.database.ToDo
import com.example.databasesmarvelacademy.database.ToDoDao
import kotlinx.coroutines.launch

class MainViewModel(
    private val database: ToDoDao
) : ViewModel() {

    /***
     * Create a val "toDos" that calls the LiveData of all to dos
     */
    val toDos = database.getAllToDos()


    /***
     * Create a function "insertToDo" that inserts a to do in the database
     */
    fun insertToDo(toDo: ToDo) = viewModelScope.launch {
        database.insert(toDo)
    }


    /***
     * Create a function "updateToDo" that updates a to do in the database
     */
    fun updateToDo(toDo: ToDo)= viewModelScope.launch {
        database.update(toDo)
    }


    /***
     * Create a function "deleteAllToDos" that deletes all to dos in the database
     */
    fun deleteAllToDos() = viewModelScope.launch {
        database.deleteAll()
    }


}
