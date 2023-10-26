package com.harish.data.mapper

import com.harish.core.Mapper
import com.harish.data.model.PokemonDTO
import com.harish.data.model.PokemonListDTO
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonModel
import javax.inject.Inject

class PokemonListDTOMapper @Inject constructor(private val pokemonDTOToModelMapper: PokemonDTOToModelMapper) :
    Mapper<PokemonListDTO, PokemonList> {
    override infix fun mapFrom(from: PokemonListDTO): PokemonList {

        return PokemonList(
            pokemonList = from.pokemonDTOS.map { data -> pokemonDTOToModelMapper mapFrom data }
        )
    }

}


class PokemonDTOToModelMapper @Inject constructor() : Mapper<PokemonDTO, PokemonModel> {
    override infix fun mapFrom(from: PokemonDTO): PokemonModel {
        return PokemonModel(
            name = from.name,
            url = from.url,
        )
    }

}
