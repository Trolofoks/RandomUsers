package com.honey.randomusers.screens.main.view.fullscreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.randomusers.screens.main.model.MainViewState

@Composable
fun MainViewSureExit(
    viewState: MainViewState.OnExit,
    response: ((sure: Boolean)-> Unit)? = null
){
    BackHandler {
        response?.invoke(true)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
    ){
        Card(modifier = Modifier.fillMaxWidth(0.9f)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Do you sure to leave this beautifully app? Don't forget me!",
                modifier = Modifier.align(CenterHorizontally))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier.weight(0.4f),
                        onClick = {
                            response?.invoke(false)
                        }
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        modifier = Modifier.weight(0.4f),
                        onClick = {
                            response?.invoke(true)
                        }
                    ) {
                        Text(text = "I'm sure")
                    }
                }
            }
        }
    }
}