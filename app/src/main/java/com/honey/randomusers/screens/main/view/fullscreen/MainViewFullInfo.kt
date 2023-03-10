package com.honey.randomusers.screens.main.view.fullscreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.honey.randomusers.R
import com.honey.randomusers.screens.main.model.SpeakerItemModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainViewFullInfo(
    model: SpeakerItemModel,
    onExit: (() -> Unit)? = null
){
    BackHandler {
        onExit?.invoke()
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        //photo,name
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                modifier = Modifier
                    .size(320.dp)
                    .clip(shape = RoundedCornerShape(100)),
                painter = rememberImagePainter(data = "https://static.tildacdn.com/tild3432-3435-4561-b136-663134643162/photo_2021-04-16_18-.jpg",),                contentDescription = "Speaker Photo",
                contentScale = ContentScale.Crop
            )
            Text(text = model.speaker, style = MaterialTheme.typography.h4)
        }
        //date, full text
        Column(modifier = Modifier.padding(top = 32.dp)) {
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar"
                )
                Text(text = model.date.toString() + " Month  ", style = MaterialTheme.typography.h6)
                Text(text = model.timeZone, style = MaterialTheme.typography.h6)
            }   
            Text(text = model.text, style = MaterialTheme.typography.h6)
        }
    }
}

@Preview
@Composable
fun PreviewFullInfo(){
    MainViewFullInfo(
        model = SpeakerItemModel(
            timeZone = "10:00-11:00",
            speaker = "Аналий Жопанов",
            text = "Доклад: А тут текста я не придумал так что пусть будет просто текст",
            inFav = true
        )
    )
}