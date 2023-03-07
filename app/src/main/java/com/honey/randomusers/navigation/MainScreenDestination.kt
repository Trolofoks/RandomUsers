package com.honey.randomusers.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.honey.randomusers.screens.main.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.honey.randomusers.screens.main.MainScreen
import com.honey.randomusers.screens.main.model.MainEffect
import com.honey.randomusers.screens.main.model.MainEvent

@Composable
fun MainScreenDestination(navController: NavController){
    val viewModel = viewModel<MainViewModel>()
    MainScreen(
        navController = navController,
        mainViewModel = viewModel,
        onNavigationRequested = { navEffect ->
            if (navEffect is MainEffect.Navigation.ToFullView){
                navController.navigateToFullView(navEffect.speakerId)
            }

        }
    )
}