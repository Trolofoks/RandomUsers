package com.honey.randomusers.example.testviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.honey.randomusers.example.SecondKittenView
import com.honey.randomusers.example.mvi.Kitten3ViewModel

@Preview
@Composable
fun MainKittenScreen(
    viewModel: KittenViewModel = KittenViewModel(),
    viewModel3: Kitten3ViewModel = Kitten3ViewModel()
){
    val count: Int = viewModel.kitten
    val count2 = (viewModel.kitten2.collectAsState()).value

    SecondKittenView(count = count, onNewKitten = { viewModel.releaseNewKittens() })
}