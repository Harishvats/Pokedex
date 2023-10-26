package com.harish.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PokemonGenderDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("pokemon_species_details")
    val pokemonSpeciesDetailDTOS: List<PokemonSpeciesDetailDTO>,
)
@Serializable
data class PokemonSpeciesDTO(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
@Serializable
data class PokemonSpeciesDetailDTO(
    @SerialName("pokemon_species")
    val pokemonSpeciesDTO: PokemonSpeciesDTO,
    @SerialName("rate")
    val rate: Int
)
