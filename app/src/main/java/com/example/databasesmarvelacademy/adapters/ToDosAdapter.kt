package com.example.databasesmarvelacademy.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.databasesmarvelacademy.R
import com.example.databasesmarvelacademy.database.ToDo

class ToDosAdapter(private val checkToDo: (toDO: ToDo) -> Unit) : ListAdapter<ToDo, ToDosAdapter.ToDoHolder>(ToDosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false))

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) = holder.bind(getItem(position), checkToDo)

    inner class ToDoHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val toDoItem: CheckBox = view.findViewById(R.id.toDoTitle)

        fun bind(toDo: ToDo, checkToDo: (toDO: ToDo) -> Unit) {
            toDoItem.text = toDo.title
            toDoItem.isChecked = toDo.done
            toDoItem.setOnClickListener {
                toDo.done = toDoItem.isChecked
                checkToDo(toDo)
            }
        }
    }
}

class ToDosDiffCallback : DiffUtil.ItemCallback<ToDo>() {
    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem == newItem
}
