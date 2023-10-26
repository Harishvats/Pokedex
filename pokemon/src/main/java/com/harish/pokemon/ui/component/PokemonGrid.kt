package com.harish.pokemon.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harish.domain.model.PokemonModel

@Composable
fun PokemonGrid(
    pokemonList: List<PokemonModel>,
    modifier: Modifier,
    selectedPokemon: () -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        content = {
            items(pokemonList.size) {
                PokemonCard(
                    pokemonName = pokemonList[it].name,
                    pokemonId = it.toString(),
                    selectedPokemon
                )
            }
        })
}