package com.example.noteappdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
//    private val _todoList = MutableLiveData<List<datanote>>()

    val roomTodo = MainApplication.todoDatabase.getTodoDao()

    val todoList: LiveData<List<datanote>> = roomTodo.getAllTodo()


//    fun getAllTodo() {
//        _todoList.value = TodoManager.getAllTodo()
//
//    }

    fun deleteTodo(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            roomTodo.deleteTodo(id)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String) {
        viewModelScope.launch(Dispatchers.IO) {
        roomTodo.addTodo(datanote(title = title , Date = Date.from(Instant.now())))
    }
    }


}