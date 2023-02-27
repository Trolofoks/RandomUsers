package com.honey.randomusers.screens.main.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.honey.randomusers.R
import com.honey.randomusers.screens.main.model.SpeakerItemModel


@Composable
internal fun FavoriteCardView(
    model: SpeakerItemModel,
    onCardClicked: ((cardModel: SpeakerItemModel) -> Unit)? = null
){
    Card(
        modifier = Modifier
            .clickable { onCardClicked?.invoke(model) }
            .padding(8.dp)
            .size(160.dp)
            .aspectRatio(1f),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.background,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(text = model.timeZone, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text = model.date.toString() + " Апреля")
            Text(text = model.speaker, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
            val text = if (model.text.length > 40){
                model.text.substring(0..37) + "..."
            } else {
                model.text
            }
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun PreviewFavoriteCard(){
    FavoriteCardView(
        model = SpeakerItemModel(
            imageId = R.drawable.img_man_one,
            date = 15,
            timeZone = "10:00-11:00",
            speaker = "Аналий Жопанов",
            text = "Доклад: А тут текста я не придумал так что пусть будет просто текст",
            inFav = true
        )
    )
}