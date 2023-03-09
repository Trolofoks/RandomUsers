package com.honey.randomusers.screens.main.view.part

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.randomusers.screens.main.model.MainViewState

@Composable
fun SureBigCardView(
    firstText : String = "",
    secondText : String = "",
    cancelButtonText : String = "",
    sureButtonText : String = "",
    response: ((sure: Boolean)-> Unit)? = null
){
    BackHandler {
        response?.invoke(true)
    }

    Card(modifier = Modifier.fillMaxWidth(0.9f)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = firstText,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = secondText,
                modifier = Modifier.align(Alignment.CenterHorizontally))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)) {
                Button(
                    modifier = Modifier.weight(0.4f),
                    onClick = {
                        response?.invoke(false)
                    }
                ) {
                    Text(text = cancelButtonText)
                }
                Box(modifier = Modifier.weight(0.2f))
                Button(
                    modifier = Modifier.weight(0.4f),
                    onClick = {
                        response?.invoke(true)
                    }
                ) {
                    Text(text = sureButtonText)
                }
            }
        }
    }
}