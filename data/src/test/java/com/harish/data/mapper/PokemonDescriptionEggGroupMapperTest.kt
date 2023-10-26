package com.harish.data.mapper

import com.harish.data.pokemonEggGroup
import com.harish.data.pokemonEggGroupDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonDescriptionEggGroupMapperTest{

    private lateinit var mapper: PokemonDescriptionEggGroupMapper

    @Before
    fun setUp() {
        mapper = PokemonDescriptionEggGroupMapper()
    }

    @Test
    fun `PokemonDescriptionEggGroupMapper maps input EggGroup DTO to domain model`(){
        val result = mapper.mapFrom(pokemonEggGroupDTO)
        Assert.assertEquals(result.name, pokemonEggGroup.name)
    }

}