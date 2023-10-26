package com.harish.domain.model

data class PokemonGender (
    val pokemonSpeciesDetails: List<PokemonSpecies>,
)

data class PokemonSpecies(
    val name: String,
    val url: String
)