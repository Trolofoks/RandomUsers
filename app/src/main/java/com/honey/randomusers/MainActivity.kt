package com.honey.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honey.randomusers.navigation.AppNavigation
import com.honey.randomusers.navigation.Screen
import com.honey.randomusers.screens.fullinfo.FullInfoScreen
import com.honey.randomusers.screens.fullinfo.FullInfoViewModel
import com.honey.randomusers.screens.main.MainScreen
import com.honey.randomusers.screens.main.MainViewModel
import com.honey.randomusers.ui.theme.RandomUsersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    val viewModel : MainViewModel by viewModels()
//    val fullViewModel: FullInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomUsersTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
