package com.harish.pokemon.ui.component.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.StatsBackground
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun PokemonStatsComponent(statName: String, statProgressValue: String, progress: Float) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(StatsBackground)
    ) {

        Column(modifier = Modifier.padding(20.dp)) {
            CustomText(
                text = stringResource(id = R.string.stats),
                textSize = 20,
                fontWeight = FontWeight.Bold.weight,
                textColor = TextColor,
            )

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = statName,
                    textSize = 16,
                    fontWeight = FontWeight.Normal.weight,
                    textColor = TextColor,
                )

                Box(modifier = Modifier.height(15.dp)) {
                    LinearProgressIndicator(
                        progress = progress,
                        modifier = Modifier.fillMaxHeight(),
                        color = TextColor,
                        trackColor = Fire
                    )
                    Text(
                        text = statProgressValue,
                        modifier = Modifier.padding(start = 5.dp),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                    )
                }
            }
        }
    }
}

