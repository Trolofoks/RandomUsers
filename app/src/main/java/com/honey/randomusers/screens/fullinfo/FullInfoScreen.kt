package com.honey.randomusers.screens.fullinfo

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.honey.randomusers.screens.fullinfo.model.FullEvent
import com.honey.randomusers.screens.fullinfo.model.FullViewState
import com.honey.randomusers.screens.fullinfo.view.FullViewMain

@Composable
fun FullInfoScreen(
    navController: NavController,
    viewModel: FullInfoViewModel = FullInfoViewModel(),
    item: String
){
    val viewState = viewModel.fullViewState.collectAsState()

    when (val state = viewState.value){
        is FullViewState.FullInfo -> {
            FullViewMain(
                model = state.speaker,
                onExit = {
                    viewModel.obtainEvent((FullEvent.OnBackPress))
                }
            )
        }
        is FullViewState.Loading -> {
            Text(text = item)
        }
        is FullViewState.FullScreenImage -> {

        }
    }
}