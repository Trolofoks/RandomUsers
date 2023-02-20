package com.honey.randomusers.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun KittenView() {
    Box {
        Text(text = "Hi Kitty")
    }
}
val myItem = listOf<Int>(1,2,3,4,5,6,7,8,9,213,12,31,3,123,12,3,123,12,3,12,3)
@Preview
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