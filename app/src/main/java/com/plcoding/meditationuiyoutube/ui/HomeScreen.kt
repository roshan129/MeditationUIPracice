package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.BottomMenuContent
import com.plcoding.meditationuiyoutube.Feature
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.Beige3
import com.plcoding.meditationuiyoutube.ui.theme.BlueViolet3
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.ui.theme.LightGreen3
import com.plcoding.meditationuiyoutube.ui.theme.LightRed
import com.plcoding.meditationuiyoutube.ui.theme.OrangeYellow1
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
            DailyMeditationSection()
            FeaturedSection(
                listOf(
                    Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet3
                    ),
                    Feature(
                        "Tips For sleeping",
                        R.drawable.ic_videocam,
                        LightGreen3
                    ),
                    Feature(
                        "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1
                    ),
                    Feature(
                        "Calming sounds",
                        R.drawable.ic_videocam,
                        Beige3
                    )
                )
            )

        }
        BottomNavigationBar(
            listOf(
                BottomMenuContent(
                    "Home",
                    R.drawable.ic_home
                ),
                BottomMenuContent(
                    "Meditate",
                    R.drawable.ic_bubble
                ),
                BottomMenuContent(
                    "Sleep",
                    R.drawable.ic_moon
                ),
                BottomMenuContent(
                    "Music",
                    R.drawable.ic_music
                ),
                BottomMenuContent(
                    "Profile",
                    R.drawable.ic_profile
                )
            ),
            modifier = Modifier.align(BottomCenter)
        )
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
        LazyRow(modifier = Modifier.fillMaxWidth()) {
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

@Composable
fun DailyMeditationSection() {

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(LightRed)


    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "Daily Thought",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite
                )
                Text(
                    text = "Meditation : 3-10 min",
                    fontSize = 12.sp,
                    color = TextWhite
                )
            }
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play Button",
                    modifier = Modifier.padding(16.dp),
                    tint = TextWhite

                )

            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(
    featureList: List<Feature>
) {


    Column {
        Text(
            text = "Featured",
            fontSize = 20.sp,
            color = TextWhite,
            modifier = Modifier.padding(start = 16.dp)
        )

        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            items(featureList.size) {
                FeatureItem(featureList[it])
            }
        })

    }

}

@Composable
fun FeatureItem(feature: Feature) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(feature.darkColor)
            .aspectRatio(1f)
            .padding(12.dp)
    ) {

        Text(
            text = feature.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = TextWhite, textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = "Headphone",
            modifier = Modifier
                .padding(start = 12.dp)
                .align(Alignment.BottomStart),
            tint = TextWhite
        )
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(ButtonBlue)
                .align(Alignment.BottomEnd)
        ) {
            Text(text = "Start", color = TextWhite)
        }
    }
}

@Composable
fun BottomNavigationBar(
    bottomList: List<BottomMenuContent>,
    modifier: Modifier
) {


    val selectedItemIndex = remember {
        mutableStateOf(0)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(DeepBlue),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        bottomList.forEachIndexed { index, item ->
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier.clickable {
                    selectedItemIndex.value = index
                }
            ) {
                Box(modifier = Modifier.clip(RoundedCornerShape(6.dp))) {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.title,
                        modifier = Modifier.background(
                            color = if (selectedItemIndex.value == index) ButtonBlue else Color.Transparent
                        ).padding(8.dp).size(20.dp),
                        tint = TextWhite
                    )
                }
                Text(text = item.title, color = TextWhite)
            }
        }


    }
}






