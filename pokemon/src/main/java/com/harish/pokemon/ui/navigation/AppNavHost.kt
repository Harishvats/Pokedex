package com.harish.pokemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.harish.pokemon.ui.AppConstants.Companion.POKEMON_DETAIL_SCREEN_DESTINATION
import com.harish.pokemon.ui.AppConstants.Companion.POKEMON_LIST_SCREEN_DESTINATION
import com.harish.pokemon.ui.AppConstants.Companion.SELECTED_POKEMON_ID
import com.harish.pokemon.ui.AppConstants.Companion.SELECTED_POKEMON_NAME
import com.harish.pokemon.ui.screens.pokemonDetails.compose.PokemonDetailsScreen
import com.harish.pokemon.ui.screens.pokemonDetails.viewmodel.PokemonDetailsViewModel
import com.harish.pokemon.ui.screens.pokemonList.compose.PokemonListScreen
import com.harish.pokemon.ui.screens.pokemonList.viewmodel.PokemonListViewModel

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController(),
) {

    NavHost(navController = navHostController, startDestination = POKEMON_LIST_SCREEN_DESTINATION) {
        composable(route = POKEMON_LIST_SCREEN_DESTINATION) {
            val pokemonListViewModel = hiltViewModel<PokemonListViewModel>()

            PokemonListScreen(pokemonListViewModel) { id: String, name: String ->
                navHostController.navigate("$POKEMON_DETAIL_SCREEN_DESTINATION/$id/$name")
            }
        }
        composable(
            route = "$POKEMON_DETAIL_SCREEN_DESTINATION/{${SELECTED_POKEMON_ID}}/{${SELECTED_POKEMON_NAME}}",
            arguments = listOf(
                navArgument(SELECTED_POKEMON_ID) {
                    type = NavType.StringType
                }, navArgument(SELECTED_POKEMON_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            val pokemonDetailsViewModel = hiltViewModel<PokemonDetailsViewModel>()

            it.arguments?.let { it1 ->
                PokemonDetailsScreen(
                    pokemonDetailsViewModel, it1.getString(
                        SELECTED_POKEMON_NAME, ""
                    ), it1.getString(SELECTED_POKEMON_ID, "")
                ){
                    navHostController.navigateUp()
                }
            }
        }
    }

}