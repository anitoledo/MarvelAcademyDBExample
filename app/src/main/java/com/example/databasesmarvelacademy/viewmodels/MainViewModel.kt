package com.example.databasesmarvelacademy.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.databasesmarvelacademy.database.ToDo
import com.example.databasesmarvelacademy.database.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    val database: ToDoDao,
    application: Application
) : AndroidViewModel(application) {

    val toDos = database.getAllTodos()

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
