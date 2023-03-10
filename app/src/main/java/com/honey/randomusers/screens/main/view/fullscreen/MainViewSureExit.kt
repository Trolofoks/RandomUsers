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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.part.SureBigCardView

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
        .background(MaterialTheme.colors.background),
        contentAlignment = Center
    ){
        SureBigCardView(
            firstText = "Do you sure to leave this beautifully app?",
            secondText = "Don't forget me!",
            cancelButtonText = "Cancel",
            sureButtonText= "I'm sure",
            response = {response?.invoke(it)}
        )
    }
}