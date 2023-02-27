package com.honey.randomusers.screens.main.view.fullscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.honey.randomusers.screens.main.Keyboard
import com.honey.randomusers.screens.main.keyboardAsState
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.model.SpeakerItemModel
import com.honey.randomusers.screens.main.view.part.SearchFieldView
import com.honey.randomusers.screens.main.view.part.SpeakerCardView
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainViewSearch(
    viewState: MainViewState.Search,
    onCardClicked: ((cardModel: SpeakerItemModel) -> Unit)? = null,
    onExitSearch: ((search: String)-> Unit)? = null
){
    val isKeyboardOpen = keyboardAsState()

    val showKeyboard = remember { mutableStateOf(true) }
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    val newQuery = remember { mutableStateOf("") }

    val suitableItems = remember { mutableStateOf<List<SpeakerItemModel>?>(listOf())}

    showKeyboard.value = isKeyboardOpen.value == Keyboard.Opened

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
        ) {
            SearchFieldView(
                initialValue = viewState.searchText,
                modifier = Modifier
                    .padding(16.dp)
                    .focusRequester(focusRequester),
                onSearch = {query ->
                    newQuery.value = query
                    suitableItems.value = viewState.items.filter { it.speaker.lowercase().startsWith(query.lowercase()) }
                }
            )
            for (card in suitableItems.value!!){
                SpeakerCardView(
                    model = card,
                    onCardClicked = ({onCardClicked?.invoke(it)})
                )
            }
        }
    }
    // LaunchedEffect prevents endless focus request
    LaunchedEffect(focusRequester) {
        focusRequester.requestFocus()
        delay(100) // Make sure you have delay here
        keyboard?.show()
    }
    LaunchedEffect(showKeyboard.value){
        if (!showKeyboard.value){
            delay(500)
            if (!showKeyboard.value){
                onExitSearch?.invoke(newQuery.value)
            }
        }
    }
}

