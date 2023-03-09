package com.honey.randomusers.screens.main.view.fullscreen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.honey.randomusers.screens.main.Keyboard
import com.honey.randomusers.screens.main.keyboardAsState
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.model.SpeakerItemModel
import com.honey.randomusers.screens.main.view.FavoriteCardView
import com.honey.randomusers.screens.main.view.part.RefreshCardView
import com.honey.randomusers.screens.main.view.part.SearchFieldView
import com.honey.randomusers.screens.main.view.part.SpeakerCardView

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainViewDisplay(
    viewState: MainViewState.Display,
    onCardClicked: ((cardModel: SpeakerItemModel) -> Unit)? = null,
    onFavClicked: ((itemId: Int, newValue: Boolean) -> Unit)? = null,
    onSearch: ((search: String)-> Unit)? = null,
    onBackPress: (()-> Unit)? = null,
    onRefresh: (()-> Unit)? = null
){

    BackHandler {
        onBackPress?.invoke()
    }

    val isKeyboardOpen = keyboardAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.BottomEnd,

    ){
        if (viewState.items.isEmpty()){
            //TODO(Failed to Load add)
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
        ) {
            SearchFieldView(
                initialValue = viewState.searchText,
                modifier = Modifier.padding(16.dp),
                onSearch = {query ->
                    if (isKeyboardOpen.value == Keyboard.Opened){
                        onSearch?.invoke(query)
                    }
                }
            )

            val favorites = viewState.items.filter { it.inFav }.map { it }
            if (favorites.isNotEmpty()){
                Text(text = "Favorite")
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(favorites){index, item ->
                        FavoriteCardView(
                            model = item,
                            onCardClicked = ({ onCardClicked?.invoke(it) })
                        )
                    }
                }
            }

            Text(text = "Sessions")

            val groupedCards = viewState.items.groupBy { it.date }
            for (card in groupedCards) {
                Column {
                    Text(text = "${card.key} Month", modifier = Modifier.padding(start = 16.dp))
                    repeat(card.value.size) { index ->
                        SpeakerCardView(
                            model = card.value[index],
                            onCardClicked = ({ onCardClicked?.invoke(it) }),
                            onFavClicked = ({ itemId, newValue ->
                                onFavClicked?.invoke(itemId, newValue)
                            })
                        )
                    }
                }
            }
        }
        RefreshCardView(){
            onRefresh?.invoke()
        }
    }
}

//@Composable
//fun keyboardAsState(): State<Boolean> {
//    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
//    return rememberUpdatedState(isImeVisible)
//}

@Preview
@Composable
fun PreviewMainViewDisplay(){
    val items = listOf<SpeakerItemModel>(
        SpeakerItemModel(id = 1), SpeakerItemModel(id = 2),SpeakerItemModel(date = 2),
        SpeakerItemModel(id = 3), SpeakerItemModel(id = 4),SpeakerItemModel(date = 5),
        SpeakerItemModel(id = 5), SpeakerItemModel(id = 6),SpeakerItemModel(date = 3),
        SpeakerItemModel(), SpeakerItemModel(),SpeakerItemModel(date = 4),

    )

    MainViewDisplay(
        viewState = MainViewState
            .Display(
                items = items,
                favItems = items
            )
    )
}