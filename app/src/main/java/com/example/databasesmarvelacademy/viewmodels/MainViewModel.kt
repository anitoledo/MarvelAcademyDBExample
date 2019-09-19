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
    val toDos = database.getAllToDos()


    /***
     * Create a function "insertToDo" that inserts a to do in the database
     */
    fun insertToDo(toDo: ToDo){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.insert(toDo)
            }
        }
    }


    /***
     * Create a function "updateToDo" that updates a to do in the database
     */
    fun updateToDo(toDo: ToDo){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.update(toDo)
            }
        }
    }


    /***
     * Create a function "deleteAllToDos" that deletes all to dos in the database
     */
    fun deleteAllToDos(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                database.deleteAll()
            }
        }
    }


}
