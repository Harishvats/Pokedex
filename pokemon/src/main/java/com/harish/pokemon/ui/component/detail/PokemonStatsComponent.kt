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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.harish.domain.model.StatModel
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.StatsBackground
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun PokemonStatsComponent(stats: List<StatModel>) {

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

            if (stats.isNotEmpty()) {
                stats.forEach { statData ->

                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CustomText(
                            text = statData.stat.name,
                            textSize = 16,
                            fontWeight = FontWeight.Normal.weight,
                            textColor = TextColor,
                        )

                        Box(modifier = Modifier.height(15.dp)) {
                            LinearProgressIndicator(
                                progress = statData.statData / 100.0f,
                                modifier = Modifier.fillMaxHeight(),
                                color = TextColor,
                                trackColor = Fire
                            )
                            CustomText(
                                text = "${statData.statData}",
                                modifier = Modifier.padding(start = 5.dp),
                                textSize = 10,
                                fontWeight = FontWeight.Bold.weight,
                                textColor = Color.White,

                                )
                        }
                    }
                }
            }
        }
    }
}

