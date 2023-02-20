package com.honey.randomusers.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.honey.randomusers.screens.main.model.MainViewState

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController?,
    mainViewModel: MainViewModel
){
    val viewState = mainViewModel.mainViewState
    val helloString = remember {
        mutableStateOf("Hello you can't see this")
    }

    when (viewState){
        MainViewState.Loading -> {helloString.value = "But you can see this"}
        MainViewState.NoItems -> {}

        else -> {}
    }



    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primaryVariant)){
        Text(text = helloString.value)
    }

}