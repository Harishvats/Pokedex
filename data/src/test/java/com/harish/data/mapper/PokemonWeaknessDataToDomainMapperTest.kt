package com.harish.data.mapper

import com.harish.data.pokemonWeaknessDTO
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonWeaknessDataToDomainMapperTest {
    private lateinit var mapper: PokemonWeaknessDataToDomainMapper
    private var pokemonWeaknessItemMapper = mockk<PokemonWeaknessItemMapper>()

    @Before
    fun setUp() {
        mapper = PokemonWeaknessDataToDomainMapper(pokemonWeaknessItemMapper)
    }

    @Test
    fun `PokemonWeaknessDataToDomainMapper maps input DTO to domain model`() {
        val pokemonWeakness = mapper.mapFrom(pokemonWeaknessDTO)
        Assert.assertEquals(pokemonWeakness.weakness, pokemonWeaknessDTO.damageRelations.doubleDamageFrom)
    }

}