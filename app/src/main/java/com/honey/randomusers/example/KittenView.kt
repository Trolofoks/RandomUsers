package com.honey.randomusers.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

@Preview
@Composable
fun KittenView() {
    val counter = remember {
        mutableStateOf(1)
    }
    val animalType = remember {
        mutableStateOf("Kitten")
    }

    Column {
        Text(text = "Hi ${animalType.value} ${counter.value}")
        Button(onClick = { counter.value++ }) {
            Text(text = "Add more ${animalType.value}")
        }
        Button(onClick = {
            if (animalType.value == "Kitten") {
                counter.value = 0
                animalType.value = "Monkey"
            } else if (animalType.value == "Monkey"){
                counter.value = 0
                animalType.value = "Kitten"
            }
        }) {
            Text(text = "Change Animal Type")
        }
    }
}



val myItem = listOf<Int>(1,2,3,4,5,6,7,8,9,213,12,31,3,123,12,3,123,12,3,12,3)
@Composable
fun SimpleList(myItems: List<Any> = listOf<String>("323", "","21321", "dfdfjg")){
    LazyColumn(){
        items(myItems.size){ i->
            ItemView(item = i.toString())
        }
    }
}

@Composable
fun ItemView(item : String){
    Text(text = item)
}