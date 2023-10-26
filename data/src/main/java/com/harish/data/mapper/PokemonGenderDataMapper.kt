package com.harish.data.mapper

import com.harish.core.Mapper
import com.harish.data.model.PokemonGenderDTO
import com.harish.data.model.PokemonSpeciesDetailDTO
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonSpecies
import javax.inject.Inject

class PokemonGenderDataMapper @Inject constructor(
    private val pokemonSpeciesDataMapper: PokemonSpeciesDataMapper
) : Mapper<PokemonGenderDTO, PokemonGender> {
    override infix fun mapFrom(from: PokemonGenderDTO): PokemonGender {
        return PokemonGender(pokemonSpeciesDetails = from.pokemonSpeciesDetailDTOS.map { pokemonSpeciesDataMapper mapFrom it })
    }
}

class PokemonSpeciesDataMapper @Inject constructor() :
    Mapper<PokemonSpeciesDetailDTO, PokemonSpecies> {
    override infix fun mapFrom(from: PokemonSpeciesDetailDTO): PokemonSpecies {
        return PokemonSpecies(
            name = from.pokemonSpeciesDTO.name, url = from.pokemonSpeciesDTO.url
        )
    }
}