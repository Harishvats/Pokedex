package com.harish.data.mapper

import com.harish.data.pokemonList
import com.harish.data.pokemonListDataModel
import com.harish.data.pokemonModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonListDTOMapperTest {
    private lateinit var mapper: PokemonListDTOMapper
    private var pokemonDTOToModelMapper = mockk<PokemonDTOToModelMapper>()

    @Before
    fun setUp() {
        mapper = PokemonListDTOMapper(pokemonDTOToModelMapper)
    }

    @Test
    fun `PokemonListDTOMapper maps input DTO to domain model`() {
        coEvery { pokemonDTOToModelMapper.mapFrom(any()) } returns (pokemonModel)
        val result = mapper.mapFrom(pokemonListDataModel)
        Assert.assertEquals(result, pokemonList)
    }
}