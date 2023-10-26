package com.harish.data.mapper

import com.harish.data.pokemonDTO
import com.harish.data.pokemonModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonDTOToModelMapperTest{
    private lateinit var mapper: PokemonDTOToModelMapper

    @Before
    fun setUp() {
        mapper = PokemonDTOToModelMapper()
    }

    @Test
    fun `PokemonDescriptionDTOToDomainMapper maps input PokemonDescription DTO to domain model`(){
        val result = mapper.mapFrom(pokemonDTO)
        Assert.assertEquals(result.name, pokemonModel.name)
    }

}