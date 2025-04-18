package com.example.noteappdb.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteappdb.datanote
import java.util.jar.Attributes.Name

@Database(entities = [datanote::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase :RoomDatabase() {
    companion object{
        const val Name = "Database_db"
    }

    abstract fun getTodoDao() : TodoDao

}