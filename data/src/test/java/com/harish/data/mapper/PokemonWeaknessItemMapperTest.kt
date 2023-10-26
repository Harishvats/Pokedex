package com.harish.data.mapper

import com.harish.data.doubleDamage
import com.harish.data.doubleDamageFrom
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonWeaknessItemMapperTest {
    private lateinit var mapper: PokemonWeaknessItemMapper

    @Before
    fun setUp() {
        mapper = PokemonWeaknessItemMapper()
    }

    @Test
    fun `PokemonWeaknessItemMapper maps input DTO to domain model`() {
        val doubleDamageValue = mapper.mapFrom(doubleDamageFrom)
        Assert.assertEquals(doubleDamageValue.name, doubleDamage.name)
    }
}