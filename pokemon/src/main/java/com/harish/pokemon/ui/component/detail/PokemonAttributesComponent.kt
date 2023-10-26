package com.harish.pokemon.ui.component.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun PokemonAttributesComponent(
    attributeName: String,
    attributeValue: List<String>
) {

    Column {
        CustomText(
            text = attributeName,
            textSize = 16,
            fontWeight = FontWeight.Bold.weight,
        )

        attributeValue.forEachIndexed { index, value ->
            val text = if (index != attributeValue.size - 1) {
                "$value ${", "}"
            } else {
                value
            }

            CustomText(
                text = text.substring(0,1).uppercase() + text.substring(1).lowercase(),
                textSize = 16,
                fontWeight = FontWeight.Normal.weight,
                textColor = TextColor,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}