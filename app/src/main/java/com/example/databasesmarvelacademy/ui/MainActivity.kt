package com.example.databasesmarvelacademy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.databasesmarvelacademy.R
import com.example.databasesmarvelacademy.adapters.ToDosAdapter
import com.example.databasesmarvelacademy.database.ToDo
import com.example.databasesmarvelacademy.database.ToDoDatabase
import com.example.databasesmarvelacademy.viewmodels.MainViewModel
import com.example.databasesmarvelacademy.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ToDoDatabase.getDatabase(application).todoDao()

        val viewModelFactory = MainViewModelFactory(database, application)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        val adapter = ToDosAdapter { updateToDo(it) }

        toDoRecycler.adapter = adapter

        mainViewModel.toDos.observe(this, Observer {
            it?.let{
                adapter.submitList(it)
            }
        })

        submitToDo.setOnClickListener { insertToDO() }

        deleteAllButton.setOnClickListener { deleteAllTodos() }
    }

    private fun insertToDO(){
        mainViewModel.insertToDo(
            ToDo(
                title = createToDo.text.toString(),
                done = false
            )
        )
    }

    private fun updateToDo(toDo: ToDo){
        mainViewModel.updateToDo(toDo)
    }

    private fun deleteAllTodos(){
        mainViewModel.deleteAllToDos()
    }
}
