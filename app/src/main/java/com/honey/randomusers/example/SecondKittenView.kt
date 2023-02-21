package com.honey.randomusers.example

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SecondKittenView(count: Int, onNewKitten: () -> Unit){
    Column {
        Text(text = "Kitten counter ${count}")
        Button(onClick = onNewKitten ) {
            Text(text = "Add new Kitten")
        }
    }
}

@Composable
fun KittenHouse(){
    val count = remember { mutableStateOf(10) }
    SecondKittenView(count = count.value) { count.value += 1 }
}
@Composable
fun KittenZoo(){
    val count = remember { mutableStateOf(1) }
    SecondKittenView(count = count.value) { count.value *= 2 }
}
@Composable
fun GetAwayKitten(){
    val count = remember { mutableStateOf(20) }
    SecondKittenView(count = count.value) { count.value -= 1 }
}

@Preview
@Composable
fun TestHouse(){
    Column {
        KittenHouse()
        KittenZoo()
        GetAwayKitten()
    }
}