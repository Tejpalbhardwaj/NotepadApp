package com.example.noteappdb.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

class Converters {
    @TypeConverter
    fun toDate(date: Date):Long{
        return date.time
    }

    @TypeConverter
    fun toLong(long:Long):Date{
        return Date(long)
    }
}