package com.honey.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.honey.randomusers.example.KittenView
import com.honey.randomusers.example.mvi.Kitten3ViewModel
import com.honey.randomusers.example.testviewmodel.KittenViewModel
import com.honey.randomusers.example.testviewmodel.MainKittenScreen
import com.honey.randomusers.ui.theme.RandomUsersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomUsersTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MainKittenScreen(KittenViewModel(), Kitten3ViewModel())
                }
            }
        }
    }
}
