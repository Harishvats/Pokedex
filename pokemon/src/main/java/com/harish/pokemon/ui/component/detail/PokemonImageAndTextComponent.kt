package com.harish.pokemon.ui.component.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.Poison
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun PokemonImageAndTextComponent(showPopUp: (Boolean) -> Unit) {
    var hasVisualOverflow by remember { mutableStateOf(false) }

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp, start = 20.dp, end = 20.dp)
            .height(230.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            Modifier
                .drawWithCache {
                    onDrawBehind {
                        drawRoundRect(
                            color = Color.Black,
                            style = stroke,
                            cornerRadius = CornerRadius(8f)
                        )
                    }
                }
                .padding(1.dp)
                .background(Brush.verticalGradient(listOf(Poison, Fire)))
                .weight(1f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
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
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text =
                "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally. When expelling a blast of super text this and this that etc super text this and this that etc super text this and this that etc super text this and this that etc",
                maxLines = 8,
                onTextLayout = { hasVisualOverflow = it.hasVisualOverflow },
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextColor,
                )
            )

            if (hasVisualOverflow) {
                Text(
                    text = "Read more",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.clickable {
                        showPopUp(true)
                    }
                )
            }
        }
    }
}

