package com.honey.randomusers.screens.main.view.fullscreen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.part.SureBigCardView

@Composable
fun MainViewFavLimit(
    viewState: MainViewState.FavLimit,
    response: ((sure: Boolean)-> Unit)? = null
){
    BackHandler {
        response?.invoke(true)
    }

    Log.d("MyLog", "MainViewFavLimit")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ){
        SureBigCardView(
            firstText = "Favorite limit is 3",
            secondText = "",
            cancelButtonText = "Ok",
            sureButtonText= "Ok",
            response = {response?.invoke(it)}
        )
    }
}