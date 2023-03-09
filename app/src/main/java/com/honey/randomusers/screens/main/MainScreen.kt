package com.honey.randomusers.screens.main

import android.util.Log
import androidx.compose.runtime.*
import com.honey.randomusers.Constance
import com.honey.randomusers.navigation.Screen
import com.honey.randomusers.screens.main.model.MainEffect
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.fullscreen.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
    onNavigationRequested: (navEffect: MainEffect.Navigation) -> Unit
){
    val viewState = viewModel.mainViewState.collectAsState()
    val effect = viewModel.mainEffect
    val items = listOf(Screen.Main, Screen.Full)

    //ой сайд эффекты пошли а я их еще не знаю, неловко вышло, хотя вроде не сложно
    LaunchedEffect(Constance.SIDE_EFFECTS_KEY){
        effect.onEach {effect ->
            when(effect){
                is MainEffect.Navigation.ToFullView -> {
                    onNavigationRequested(effect)
                }
                else -> {}
            }
        }.collect()

    }

    when (val state = viewState.value){
        is MainViewState.Display -> {

            MainViewDisplay(
                viewState = state,
                onCardClicked = { item ->
                    viewModel.obtainEvent(MainEvent.OnCardClicked(item))

                },
                onFavClicked = { itemId, newValue ->
                    viewModel.obtainEvent(
                        MainEvent.OnAddFavClicked(
                            itemId = itemId,
                            newValue = newValue
                        )
                    )
                },
                onSearch = { searchText ->
                    viewModel.obtainEvent(MainEvent.SearchEnter(searchText))
                },
                onBackPress = {
                    viewModel.obtainEvent(MainEvent.OnBackPress)
                },
                onRefresh = {
                    viewModel.obtainEvent(MainEvent.ReloadPage)
                }
            )
        }
        is MainViewState.Search -> {
            MainViewSearch(
                viewState = state,
                onCardClicked = {item->
                    viewModel.obtainEvent(MainEvent.OnCardClicked(item))
                },
                onExitSearch = {searchText ->

                    viewModel.obtainEvent(MainEvent.SearchExit(searchText))
                }
            )
        }
        is MainViewState.OnExit -> {
            MainViewSureExit(
                viewState = state,
                response = {sureToExit->
                    viewModel.obtainEvent(MainEvent.SureToExit(sureToExit))
                }
            )
        }
        is MainViewState.FavLimit -> {
            MainViewFavLimit(
                viewState = state,
                response = {
                    viewModel.obtainEvent(MainEvent.OnBackPress)
                }
            )
        }
        is MainViewState.Loading -> {
            MainViewLoading(
                response = {
                    viewModel.obtainEvent(MainEvent.ReloadPage)
                }
            )
        }
        else -> {}
    }
}

