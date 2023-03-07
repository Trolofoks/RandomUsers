package com.honey.randomusers.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.honey.randomusers.screens.fullinfo.FullInfoScreen
import com.honey.randomusers.screens.fullinfo.FullInfoViewModel
import com.honey.randomusers.screens.fullinfo.model.FullEvent

@Composable
fun FullInfoScreenDestination (userId: Int, navController: NavController){
    val viewModel = viewModel<FullInfoViewModel>()
    viewModel.obtainEvent(FullEvent.OnGetId(userId))
    FullInfoScreen(
        navController = navController,
        viewModel = viewModel
    )
}