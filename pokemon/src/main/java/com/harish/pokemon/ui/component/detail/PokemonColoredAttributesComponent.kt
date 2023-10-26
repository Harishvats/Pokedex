package com.harish.pokemon.ui.component.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.TextColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonColoredAttributesComponent(
    title: String, attributes: List<String>
) {

    Column {
        CustomText(
            text = title,
            textSize = 16,
            fontWeight = FontWeight.Bold.weight,
            textColor = TextColor,

            )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 2.dp)
        ) {
            attributes.forEach {
                Box(
                    modifier = Modifier
                        .border(
                            width = .5.dp,
                            color = TextColor,
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .background(color = Fire, shape = RoundedCornerShape(size = 5.dp))
                        .padding(top = 2.dp, bottom = 2.dp, start = 5.dp, end = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CustomText(
                        text = it,
                        textSize = 16,
                        fontWeight = FontWeight.Normal.weight,
                        textColor = TextColor,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }

    }
}

