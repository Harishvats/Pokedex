package com.harish.pokemon.ui.component.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.Poison
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun EvolutionChainComponent() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
    ) {

        CustomText(
            text = "Evolution Chain",
            textSize = 20,
            fontWeight = FontWeight.Bold.weight,
            textColor = TextColor,
        )

        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val stroke = Stroke(
                width = 2f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            )

            Box(
                Modifier
                    .drawWithCache {
                        onDrawBehind {
                            drawRoundRect(
                                color = Color.Black,
                                style = stroke,
                                cornerRadius = CornerRadius(10f)
                            )
                        }
                    }
                    .padding(1.dp)
                    .background(Brush.verticalGradient(listOf(Poison, Fire))),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                        .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")
                        .setHeader("User-Agent", "Mozilla/5.0")
                        .listener(
                            onStart = {},
                            onError = { _, result ->
                                result.throwable.message?.let { Log.d("Gunjan exception", it) }
                            }
                        )
                        .build(),
                        contentDescription = "Coil",
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
            }

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                contentDescription = "Arrow",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}

