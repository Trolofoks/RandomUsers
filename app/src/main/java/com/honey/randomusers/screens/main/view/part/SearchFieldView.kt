package com.honey.randomusers.screens.main.view.part

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honey.randomusers.R


@Composable
fun SearchFieldView(
    modifier : Modifier = Modifier,
    initialValue: String = "",
    onSearch: ((query: String) -> Unit)? = null,
){
    val query = remember {
        mutableStateOf(
            TextFieldValue(
                text = initialValue,
                selection = TextRange(initialValue.length)
            )
        )
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = query.value,
        onValueChange = {newQuery->
            query.value = newQuery
            onSearch?.invoke(newQuery.text)
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search"
            )
        },
        placeholder = {Text(text = "Search")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.onSurface,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
    )
}



@Preview
@Composable
fun PreviewSearchField(){

    Column {
        SearchFieldView(
            modifier = Modifier.padding(16.dp),
            onSearch = { query ->
                Log.d("MyLog", "$query")
            }
        )
    }



}
