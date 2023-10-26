package com.harish.data.mapper

import com.harish.data.pokemonSpeciesDetail
import com.harish.data.pokemonSpeciesDetailDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonSpeciesDataMapperTest{
    private lateinit var mapper: PokemonSpeciesDataMapper
    @Before
    fun setUp() {
        mapper = PokemonSpeciesDataMapper()
    }

    @Test
    fun `PokemonListDTOMapper maps input DTO to domain model`() {
        val result = mapper.mapFrom(pokemonSpeciesDetailDTO)

        Assert.assertEquals(result, pokemonSpeciesDetail)
    }
}