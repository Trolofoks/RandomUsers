package com.honey.randomusers.screens.main.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MainViewHello(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Card(modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.8f),
                backgroundColor = MaterialTheme.colors.secondary,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    Text(
                        text = "Hi you launched it!",
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.h5
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(
                            text = "Hello Button!",
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }
}