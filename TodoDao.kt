package com.example.noteappdb.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteappdb.datanote

@Dao
interface TodoDao {

    @Query("SELECT * FROM datanote ORDER BY Date DESC")
    fun getAllTodo () : LiveData<List<datanote>>

    @Insert
    fun addTodo(todo:datanote)

    @Query("Delete from datanote where id = :id")
    fun deleteTodo(id:Int)
}