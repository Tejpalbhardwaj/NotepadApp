package com.example.noteappdb

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf<datanote>()


    fun getAllTodo(): List<datanote> {
        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(note: String) {
        todoList.add(datanote(System.currentTimeMillis().toInt(), note, Date.from(Instant.now())))
    }

    fun deleteTodo(id: Int) {
        todoList.removeIf{
            it.id == id
        }
    }


}