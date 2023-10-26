package com.harish.pokemon.ui.screens.pokemonList.viewmodel

import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonModel
import com.harish.domain.model.PokemonWeakness


val pokemonModel1 = PokemonModel(
    "Pikacchu", "testurl.com"
)
val pokemonModel2 = PokemonModel(
    "Balbasaur", "testurl.com"
)

val pokemonList = PokemonList(listOf(pokemonModel1, pokemonModel2))


val pokemonDetails = PokemonDetails(
    emptyList(),
    3, 3,
    "Pikachuu",
    emptyList(),
    emptyList(),
    13,
)

val pokemonDescription = PokemonDescription(emptyList(), "description")

val pokemonGender = PokemonGender(emptyList())

val pokemonWeakness = PokemonWeakness(emptyList())