package com.harish.pokemon.ui.component.detail

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomImage
import com.harish.pokemon.ui.theme.Fire
import com.harish.pokemon.ui.theme.Poison
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun PokemonDescriptionComponent(
    description: String,
    imageUrl: String,
    showPopUp: (Boolean) -> Unit
) {
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

            CustomImage(
                data = imageUrl,
                contentDescription = "Pokemon Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxSize()
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = description,
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
                    text = stringResource(id = R.string.read_more),
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

