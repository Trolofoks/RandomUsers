package com.honey.randomusers.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.honey.randomusers.screens.fullinfo.FullInfoScreen
import com.honey.randomusers.screens.fullinfo.FullInfoViewModel
import com.honey.randomusers.screens.fullinfo.model.FullEffect
import com.honey.randomusers.screens.fullinfo.model.FullEvent

@Composable
fun FullInfoScreenDestination (speakerId: Int, navController: NavController){
    val viewModel = hiltViewModel<FullInfoViewModel>()

    viewModel.obtainEvent(FullEvent.OnGetId(speakerId))

    FullInfoScreen(
        viewModel = viewModel,
        onNavigationRequested = { navEffect ->
            if (navEffect is FullEffect.Navigation.Back){
                navController.popBackStack()
            }
        }
    )
}