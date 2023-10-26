package com.harish.data.mapper

import com.harish.data.pokemonGender
import com.harish.data.pokemonGenderDTO
import com.harish.data.pokemonSpecies
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonGenderDataMapperTest{
    private lateinit var mapper: PokemonGenderDataMapper
    private var pokemonSpeciesDataMapper = mockk<PokemonSpeciesDataMapper>()

    @Before
    fun setUp() {
        mapper = PokemonGenderDataMapper(pokemonSpeciesDataMapper)
    }

    @Test
    fun `PokemonListDTOMapper maps input DTO to domain model`() {
        coEvery { pokemonSpeciesDataMapper.mapFrom(any()) } returns (pokemonSpecies)
        val result = mapper.mapFrom(pokemonGenderDTO)

        Assert.assertEquals(result, pokemonGender)
    }
}