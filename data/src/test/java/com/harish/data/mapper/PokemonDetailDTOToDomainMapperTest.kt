package com.harish.data.mapper

import com.harish.data.pokemonDetails
import com.harish.data.pokemonDetailsDTO
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class PokemonDetailDTOToDomainMapperTest {

    private lateinit var mapper: PokemonDetailDTOToDomainMapper

    private var abilityMapper = mockk<PokemonAbilityDataToDomainMapper>()
    private var statMapper = mockk<PokemonStatsDataToDomainMapper>()
    private var typeMapper = mockk<PokemonTypeDataToDomainMapper>()

    @Before
    fun setUp() {
        mapper = PokemonDetailDTOToDomainMapper(abilityMapper, statMapper, typeMapper)
    }

    @Test
    fun `PokemonDetailDTOToDomainMapper maps input PokemonDetails DTO to domain model`() {
        val details = mapper.mapFrom(pokemonDetailsDTO)
        Assert.assertEquals(
            details.weight, pokemonDetails.weight
        )
    }


}