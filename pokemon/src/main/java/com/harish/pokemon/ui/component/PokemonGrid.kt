package com.harish.pokemon.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harish.domain.model.PokemonModel
import com.harish.pokemon.ui.utils.AppConstants

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
                    pokemonId = (it + 1).toString(),
                    imageUrl = AppConstants.IMG_URL_PREFIX + (it + 1) + AppConstants.IMG_EXT,
                    selectedPokemon
                )
            }
        })


}

