package com.harish.pokemon.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText

@Composable
fun PokemonListScreen() {
    PageHeader()
}

@Composable
private fun PageHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(28.dp)
    ) {

        CustomText(
            text = stringResource(id = R.string.pokedex),
            textSize = 30,
            fontWeight = 700,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            thickness = 1.dp
        )
        CustomText(
            text = stringResource(id = R.string.search_pokemon),
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)

        )

    }
}