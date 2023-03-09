package com.honey.randomusers.screens.fullinfo.view

import android.util.Log
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
import androidx.compose.ui.unit.dp
import com.honey.randomusers.R
import com.honey.randomusers.screens.main.model.SpeakerItemModel

@Composable
fun FullViewMain(
    model: SpeakerItemModel,
    onExit: (() -> Unit)? = null
){

    Log.d("MyLog", "Now you in FullViewMain")

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
                painter = painterResource(id = model.imageId),
                contentDescription = "Speaker Photo",
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