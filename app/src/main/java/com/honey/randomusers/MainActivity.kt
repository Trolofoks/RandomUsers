package com.honey.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.honey.randomusers.screens.main.MainScreen
import com.honey.randomusers.screens.main.MainViewModel
import com.honey.randomusers.ui.theme.RandomUsersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            RandomUsersTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(mainViewModel = viewModel)
                }
            }
        }
    }
}
