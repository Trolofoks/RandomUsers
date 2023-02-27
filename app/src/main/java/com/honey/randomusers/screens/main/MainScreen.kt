package com.honey.randomusers.screens.main

import androidx.compose.runtime.*
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.fullscreen.MainViewDisplay
import com.honey.randomusers.screens.main.view.fullscreen.MainViewFullInfo
import com.honey.randomusers.screens.main.view.fullscreen.MainViewSearch
import com.honey.randomusers.screens.main.view.fullscreen.MainViewSureExit

@Composable
internal fun MainScreen(
    mainViewModel: MainViewModel = MainViewModel()
){
    val viewState = mainViewModel.mainViewState.collectAsState()

    when (val state = viewState.value){
        is MainViewState.Display -> {
            MainViewDisplay(
                viewState = state,
                onCardClicked = { item ->
                    mainViewModel.obtainEvent(MainEvent.OnCardClicked(item))
                },
                onFavClicked = { itemId, newValue ->
                    mainViewModel.obtainEvent(
                        MainEvent.OnAddFavClicked(
                            itemId = itemId,
                            newValue = newValue
                        )
                    )
                },
                onSearch = { searchText ->
                    mainViewModel.obtainEvent(MainEvent.SearchEnter(searchText))
                },
                onBackPress = {
                    mainViewModel.obtainEvent(MainEvent.OnBackPress)
                }
            )
        }
        is MainViewState.FullInfo ->{
            MainViewFullInfo(model = state.item, onExit = {
                mainViewModel.obtainEvent(MainEvent.OnBackPress)
            })
        }
        is MainViewState.Search -> {
            MainViewSearch(
                viewState = state,
                onCardClicked = {item->
                    mainViewModel.obtainEvent(MainEvent.OnCardClicked(item))
                },
                onExitSearch = {searchText ->

                    mainViewModel.obtainEvent(MainEvent.SearchExit(searchText))
                }
            )
        }
        is MainViewState.OnExit -> {
            MainViewSureExit(
                viewState = state,
                response = {sureToExit->
                    mainViewModel.obtainEvent(MainEvent.SureToExit(sureToExit))
                }
            )
        }
        is MainViewState.Loading -> {}
        is MainViewState.Error -> {}

        else -> {}
    }
}
