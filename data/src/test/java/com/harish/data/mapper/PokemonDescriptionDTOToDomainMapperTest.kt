package com.harish.data.mapper

import com.harish.data.model.FlavorTextEntryDTO
import com.harish.data.pokemonDescriptionDTO
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class PokemonDescriptionDTOToDomainMapperTest {

    private lateinit var mapper: PokemonDescriptionDTOToDomainMapper

    private var eggGroupMapper = mockk<PokemonDescriptionEggGroupMapper>()

    @Before
    fun setUp() {
        mapper = PokemonDescriptionDTOToDomainMapper(eggGroupMapper)
    }

    @Test
    fun `PokemonDescriptionDTOToDomainMapper maps input PokemonDescription DTO to domain model`(){
        val description = mapper.mapFrom(pokemonDescriptionDTO)
        Assert.assertEquals(description.description, combinedDescription(pokemonDescriptionDTO.flavorTextEntries))
    }


    private fun combinedDescription(flavourText: List<FlavorTextEntryDTO>): String {
        var description = ""
        flavourText.forEach {
            description += it.flavorText
        }
        return description
    }
}