package com.honey.randomusers.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.honey.randomusers.screens.main.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.honey.randomusers.screens.main.MainScreen
import com.honey.randomusers.screens.main.model.MainEffect
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@Composable
fun MainScreenDestination(navController: NavController){
    val viewModel = hiltViewModel<MainViewModel>()

    MainScreen(
        viewModel = viewModel,
        onNavigationRequested = { navEffect ->
            if (navEffect is MainEffect.Navigation.ToFullView){
                navController.navigateToFullView(navEffect.speakerId)
            }
        }
    )
}