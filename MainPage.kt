package com.example.noteappdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainPage(viewModel: TodoViewModel) {
    val getTodo = viewModel.todoList.observeAsState()

    var note by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxHeight().padding(8.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth().padding(5.dp) , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly)
        {
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                value = note,
                onValueChange = { note = it },
                label = { Text(text = "Enter Note") })
            Button(onClick = {
                viewModel.addTodo(note)
                note = ""
            },
                modifier = Modifier.height(40.dp)) {
                Text(text = "Add")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        getTodo.value?.let {
            LazyColumn(content = {
                itemsIndexed(it) { index, item ->
                    GetItem(item = item , onDelete = {viewModel.deleteTodo(id = item.id)})
                }
            })
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GetItem(item: datanote , onDelete:()->Unit) {

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.Cyan)
            .padding(12.dp) , verticalAlignment = Alignment.CenterVertically
    ) {

        Column(modifier = Modifier.weight(1f)) {

            Text(

                text = SimpleDateFormat(" HH:mm:aa ,dd/MM", Locale.ENGLISH).format(item.Date),
                fontSize = 10.sp
            )
            Text(text = item.title, fontSize = 18.sp)
        }
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }

}
