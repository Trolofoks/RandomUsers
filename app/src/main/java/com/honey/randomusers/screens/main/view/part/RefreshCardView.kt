package com.honey.randomusers.screens.main.view.part

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honey.randomusers.R

@Composable
fun RefreshCardView(
    modifier: Modifier = Modifier,
    response: (() -> Unit)? = null
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colors.background),
            shape = MaterialTheme.shapes.large,
            elevation = 8.dp
        ) {
            IconButton(
                onClick = { response?.invoke() },
                modifier = modifier
                    .size(64.dp)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_loading),
                    contentDescription = "Loading"
                )
            }
        }
    }
}