package com.honey.randomusers.screens.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.honey.randomusers.R
import com.honey.randomusers.navigation.Router
import com.honey.randomusers.navigation.Screen
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.view.fullscreen.MainViewDisplay
import com.honey.randomusers.screens.main.view.fullscreen.MainViewFullInfo
import com.honey.randomusers.screens.main.view.fullscreen.MainViewSearch
import com.honey.randomusers.screens.main.view.fullscreen.MainViewSureExit

@Composable
internal fun MainScreen(
    navController: NavController,
//    router: Router,
    mainViewModel: MainViewModel
){
    val viewState = mainViewModel.mainViewState.collectAsState()
    val items = listOf(Screen.Main, Screen.Full)

    Scaffold(
        topBar = {
            TopAppBar (
                title = { Text(text = "Main Screen")},
                Modifier.background(color = MaterialTheme.colors.primary),
                navigationIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_favorite), contentDescription = "Back")
                    Log.d("MyLog", "Work Test")
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it))
    }

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

            navController.navigate("full/model123")

//            MainViewFullInfo(model = state.item, onExit = {
//                mainViewModel.obtainEvent(MainEvent.OnBackPress)
//            })
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
