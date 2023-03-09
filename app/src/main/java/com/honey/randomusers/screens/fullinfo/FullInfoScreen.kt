package com.honey.randomusers.screens.fullinfo

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.honey.randomusers.Constance
import com.honey.randomusers.screens.fullinfo.model.FullEffect
import com.honey.randomusers.screens.fullinfo.model.FullEvent
import com.honey.randomusers.screens.fullinfo.model.FullViewState
import com.honey.randomusers.screens.fullinfo.view.FullViewMain
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun FullInfoScreen(
    viewModel: FullInfoViewModel,
    onNavigationRequested: (navEffect: FullEffect.Navigation) -> Unit
){

    val viewState = viewModel.fullViewState.collectAsState()
    val effect = viewModel.fullEffect

    LaunchedEffect(Constance.SIDE_EFFECTS_KEY){
        effect.onEach {effect ->
            when(effect){
                is FullEffect.Navigation.Back -> {
                    onNavigationRequested(FullEffect.Navigation.Back)
                }
                else -> {}
            }
        }.collect()
    }

    when (val state = viewState.value){
        is FullViewState.FullInfo -> {
            FullViewMain(
                model = state.speaker,
                onExit = {
                    onNavigationRequested(FullEffect.Navigation.Back)
                }
            )
        }
        is FullViewState.Loading -> {}
        is FullViewState.FullScreenImage -> {}
    }
}