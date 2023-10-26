package com.harish.pokemon.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.harish.pokemon.ui.utils.Utils
import com.harish.pokemon.ui.theme.Ice
import com.harish.pokemon.ui.theme.Water

@Composable
fun PokemonCard(
    pokemonName: String,
    pokemonId: String,
    imageUrl: String,
    selectedPokemon: () -> Unit
) {

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )


    Box(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
            .background(Brush.verticalGradient(listOf(Water, Ice)))
            .drawBehind { drawRoundRect(color = Color.Black, style = stroke) },

        ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.Center)
                .clickable { selectedPokemon() }

        ) {
            Log.d("Harish",imageUrl)
            CustomImage(
                data = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomText(
                text = pokemonName.replaceFirstChar { firstChar -> firstChar.uppercase() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomText(
                text = Utils.formatId(pokemonId), modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}