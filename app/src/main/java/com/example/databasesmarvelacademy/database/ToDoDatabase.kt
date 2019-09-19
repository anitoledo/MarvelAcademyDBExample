package com.example.databasesmarvelacademy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/***
 * Create your To Do Database
 */

@Database(
    entities = [ToDo::class],
    version = 1
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            tempInstance?.let {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "to_do_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
