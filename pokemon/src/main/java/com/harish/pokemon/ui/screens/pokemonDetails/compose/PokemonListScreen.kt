package com.harish.pokemon.ui.screens.pokemonDetails.compose

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harish.core.ViewState
import com.harish.domain.model.PokemonModel
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.PokemonGrid
import com.harish.pokemon.ui.component.SearchField
import com.harish.pokemon.ui.screens.pokemonList.viewmodel.PokemonListViewModel

@Composable
fun PokemonListScreen(pokemonListViewModel: PokemonListViewModel, selectedPokemon: () -> Unit) {

    Column() {
        PokemonListPageHeader()
        SearchField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp, start = 28.dp, end = 28.dp)
        )
        val resultValue = pokemonListViewModel.pokemonListStateFlow.collectAsState()
        val context = LocalContext.current

        when (resultValue.value) {
            is ViewState.ErrorState -> Toast.makeText(
                context, (resultValue.value as ViewState.ErrorState).message, Toast.LENGTH_SHORT
            ).show()

            is ViewState.LoadingState -> Toast.makeText(
                context, stringResource(id = R.string.fetching_pokemons), Toast.LENGTH_SHORT
            ).show()

            is ViewState.SuccessState -> PokemonGrid(
                (resultValue.value as ViewState.SuccessState<List<PokemonModel>>).data,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(

                        start = 18.dp, end = 18.dp
                    ),
                selectedPokemon
            )

            else -> {}
        }


//        FilterDialog()
    }

}

