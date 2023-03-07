package com.honey.randomusers.screens.main.view.fullscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honey.randomusers.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainViewLoading(
    response: (() -> Unit)? = null
) {
    val string = remember{ mutableStateOf("Loading")}
    val retryCounter = remember{ mutableStateOf(0)}

    @Composable
    fun sideEffect(){
        LaunchedEffect(string){
            for (i in 0..3){
                for ( i in 0..10){
                    delay(200)
                    loadingAnimation(string)
                }
                response?.invoke()
            }
            string.value = "Error, click to retry"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .clickable {
                if (string.value.length > 10) {
                    string.value = "Retry ${retryCounter.value++} times"
                    response?.invoke()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = string.value, style = MaterialTheme.typography.h3)
    }

    sideEffect()
}

private fun loadingAnimation(string: MutableState<String>){
    if( string.value.length >= 10){
        string.value = "Loading"
    } else {
        string.value = string.value + "."
    }
}

@Preview
@Composable
fun PreviewMainViewLoading(){
    MainViewLoading()
}