package com.harish.pokemon.ui.screens.pokemonDetails.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.TextColor
import com.harish.pokemon.ui.utils.Utils

@Composable
fun DetailPageHeader(pokemonName: String, pokemonId: String,onCloseClicked:()->Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CustomText(
                text = pokemonName.replaceFirstChar { firstChar -> firstChar.uppercase() },
                textSize = 30,
                fontWeight = 800,
            )

            Image(painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "Close",
                contentScale = ContentScale.None,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        onCloseClicked()
                    })

        }

        CustomText(
            text = Utils.formatId(pokemonId),
            textSize = 30,
            fontWeight = FontWeight.Normal.weight,
            textColor = TextColor,
        )
    }
}

