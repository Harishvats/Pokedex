package com.harish.data.mapper

import com.harish.data.pokemonDescriptionFlavorTextEntry
import com.harish.data.pokemonDescriptionFlavorTextEntryDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonDescriptionFlavourTextMapperTest {

    private lateinit var mapper: PokemonDescriptionFlavourTextMapper

    @Before
    fun setUp() {
        mapper = PokemonDescriptionFlavourTextMapper()
    }

    @Test
    fun `PokemonDescriptionEggGroupMapper maps input FlavourText DTO to domain model`(){
        val result = mapper.mapFrom(pokemonDescriptionFlavorTextEntryDTO)
        Assert.assertEquals(result.flavorText, pokemonDescriptionFlavorTextEntry.flavorText)
    }
}