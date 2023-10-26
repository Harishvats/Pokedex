package com.harish.pokemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harish.pokemon.ui.AppConstants.Companion.POKEMON_DETAIL_SCREEN_DESTINATION
import com.harish.pokemon.ui.AppConstants.Companion.POKEMON_LIST_SCREEN_DESTINATION
import com.harish.pokemon.ui.screens.pokemonDetails.compose.PokemonListScreen
import com.harish.pokemon.ui.screens.pokemonList.compose.PokemonDetailsScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navHostController, startDestination = POKEMON_LIST_SCREEN_DESTINATION) {
        composable(route = POKEMON_LIST_SCREEN_DESTINATION) {
            PokemonListScreen() {
                navHostController.navigate(POKEMON_DETAIL_SCREEN_DESTINATION)
            }
        }
        composable(
            route = POKEMON_DETAIL_SCREEN_DESTINATION,
        ) {
            PokemonDetailsScreen()
        }
    }

}