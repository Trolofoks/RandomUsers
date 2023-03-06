package com.honey.randomusers.screens.main.view.fullscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honey.randomusers.R

@Composable
fun MainViewLoading(
    response: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {response?.invoke()},
                modifier = Modifier.size(128.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_loading),
                    contentDescription = "Loading"
                )
            }
            Text(
                text = "Click",
                style = (MaterialTheme.typography.subtitle1)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainViewLoading(){
    MainViewLoading()
}