package com.honey.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honey.randomusers.navigation.Screen
import com.honey.randomusers.navigation.createExternalRouter
import com.honey.randomusers.screens.fullinfo.FullInfoScreen
import com.honey.randomusers.screens.fullinfo.FullInfoViewModel
import com.honey.randomusers.screens.main.MainScreen
import com.honey.randomusers.screens.main.MainViewModel
import com.honey.randomusers.screens.main.view.fullscreen.MainViewFullInfo
import com.honey.randomusers.ui.theme.RandomUsersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val fullViewModel = viewModel<FullInfoViewModel>()
            RandomUsersTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.Main.screenName ){
                        composable(Screen.Main.screenName){
                            MainScreen(
                                navController = navController,
//                                createExternalRouter {screen, params ->
//                                    navController.navigate(screen, params)
//                                },
                                mainViewModel = viewModel
                            )
                        }
                        composable("full/{item}"){
                            FullInfoScreen(
                                viewModel = fullViewModel,
                                navController = navController,
                                item = it.arguments?.getString("item")?: ""
                            )
                        }
                    }

                }
            }
        }
    }
}
