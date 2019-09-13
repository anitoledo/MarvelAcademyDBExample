package com.example.databasesmarvelacademy.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.databasesmarvelacademy.database.ToDo
import com.example.databasesmarvelacademy.database.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    val database: ToDoDao
) : ViewModel() {

    /***
     * Create a val "toDos" that calls the LiveData of all to dos
     */



    /***
     * Create a function "insertToDo" that inserts a to do in the database
     */



    /***
     * Create a function "updateToDo" that updates a to do in the database
     */



    /***
     * Create a function "deleteAllToDos" that deletes all to dos in the database
     */



}
