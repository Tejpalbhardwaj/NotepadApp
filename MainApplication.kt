package com.example.noteappdb

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteappdb.db.TodoDatabase

class MainApplication : Application() {

    companion object{
        lateinit var todoDatabase  : TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
       todoDatabase = Room.databaseBuilder(
            applicationContext,
           TodoDatabase::class.java,
            TodoDatabase.Name
        ).build()

    }


}