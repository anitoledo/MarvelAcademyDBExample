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

class MainViewModelSolution(
    val database: ToDoDao
) : ViewModel() {

    val toDos = database.getAllToDos()

    fun insertToDo(toDo: ToDo){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.insert(toDo)
            }
        }
    }

    fun updateToDo(toDo: ToDo){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.update(toDo)
            }
        }
    }

    fun deleteAllToDos(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.deleteAll()
            }
        }
    }
}
