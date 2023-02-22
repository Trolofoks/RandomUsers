package com.honey.randomusers.screens.main.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class SpeakerCardModel(
    val imageId: Int,
    val title: String,
    val text: String
)

@Composable
internal fun SpeakerCardView(
    model: SpeakerCardModel,
    onCardClicked: (() -> Unit)? = null
) {
    Card(modifier = Modifier
        .clickable { onCardClicked?.invoke() }
        .padding(
            vertical = 8.dp,
            horizontal = 16.dp
        )
        .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.background,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Imag")
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "TextPreview")
                Text(text = "TextText")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSpeakerCard(){
    SpeakerCardView(model = SpeakerCardModel(123,"123","321"))
}