package com.example.noteappdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class datanote(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0 ,
    val title: String ,
    val Date : Date
)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo():List<datanote>{
    return listOf(
        datanote(1,"This is the first note", Date.from(Instant.now())),
        datanote(2,"This is the second note", Date.from(Instant.now())),
        datanote(3,"This is the third note", Date.from(Instant.now())),
        datanote(4,"This is the fourth note", Date.from(Instant.now())),

    )
}