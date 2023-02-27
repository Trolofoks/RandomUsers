package com.honey.randomusers.screens.main

import android.util.Log
import androidx.compose.runtime.*
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.fullscreen.MainViewDisplay
import com.honey.randomusers.screens.main.view.fullscreen.MainViewFullInfo
import com.honey.randomusers.screens.main.view.fullscreen.MainViewSearch

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
                }
            )
        }
        is MainViewState.FullInfo ->{
            MainViewFullInfo(model = state.item)
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

        is MainViewState.Loading -> {}
        is MainViewState.Error -> {}

        else -> {}
    }
}
