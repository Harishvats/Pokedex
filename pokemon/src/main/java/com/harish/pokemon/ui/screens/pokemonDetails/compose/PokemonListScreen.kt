package com.harish.pokemon.ui.screens.pokemonDetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harish.pokemon.ui.component.FilterDialog
import com.harish.pokemon.ui.component.PokemonGrid
import com.harish.pokemon.ui.component.SearchField

@Composable
fun PokemonListScreen(selectedPokemon: () -> Unit) {
    Column() {
        PokemonListPageHeader()
        SearchField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp, start = 28.dp, end = 28.dp)
        )
        PokemonGrid(
            modifier = Modifier
                .fillMaxWidth()
                .padding(

                    start = 18.dp,
                    end = 18.dp
                ), selectedPokemon
        )
        FilterDialog()
    }

}

