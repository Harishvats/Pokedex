package com.harish.pokemon.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun PokemonCard(pokemonName: String, pokemonId: String) {

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )


    Box(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
            .background(Color.Yellow)
            .drawBehind { drawRoundRect(color = Color.Black, style = stroke) },

        ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.Center)

        ) {
            CustomImage(
                data = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp).padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomText(
                text = pokemonName, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomText(
                text = pokemonId, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}