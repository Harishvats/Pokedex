package com.harish.domain.usecase

import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonModel
import com.harish.domain.model.PokemonWeakness


val pokemonModel = PokemonModel(
    "Pikacchu", "testurl.com"
)

val pokemonList = PokemonList(listOf(pokemonModel))


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