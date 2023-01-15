package com.plcoding.meditationuiyoutube.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.ui.theme.TextWhite


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 16.dp)
    ) {

        Column {

            GreetingSection()
            ChipSection(listOf("Sweet Sleep", "Insomnia", "Depression", "Deep Sleep"))

        }
    }

}

@Composable
fun GreetingSection(
    name: String = "Roshan"
) {

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = "Good Morning, $name",
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                fontSize = 16.sp
            )
            Text(text = "We wish you have a good day!", fontSize = 12.sp, color = TextWhite)
        }

        Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")

    }
}

@Composable
fun ChipSection(
    chipList: List<String> = mutableListOf(),

    ) {

    var selectedItemIndex = remember {
        mutableStateOf(0)
    }
    Box(modifier = Modifier.padding(top = 16.dp, end = 16.dp, bottom = 16.dp)) {
        LazyRow(modifier = Modifier.fillMaxWidth(),) {
            itemsIndexed(chipList) { index: Int, item: String ->

                Box(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            color = if (selectedItemIndex.value == index) ButtonBlue else DarkerButtonBlue
                        )
                        .padding(12.dp)
                        .clickable {
                            selectedItemIndex.value = index
                        }
                ) {

                    Text(text = item, color = TextWhite, fontSize = 16.sp)
                }
            }

        }

    }



}





