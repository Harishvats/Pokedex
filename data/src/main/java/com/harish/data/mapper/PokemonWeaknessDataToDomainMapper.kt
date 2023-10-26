package com.harish.data.mapper

import com.harish.core.Mapper
import com.harish.data.model.DoubleDamageFrom
import com.harish.data.model.PokemonWeaknessDTO
import com.harish.domain.model.DoubleDamage
import com.harish.domain.model.PokemonWeakness
import javax.inject.Inject

class PokemonWeaknessDataToDomainMapper @Inject constructor(
    private val pokemonWeaknessItemMapper: PokemonWeaknessItemMapper
) : Mapper<PokemonWeaknessDTO, PokemonWeakness> {
    override infix fun mapFrom(from: PokemonWeaknessDTO): PokemonWeakness {
        return PokemonWeakness(weakness =
        from.damageRelations.doubleDamageFrom.map {
            pokemonWeaknessItemMapper mapFrom it
        })
    }
}

class PokemonWeaknessItemMapper @Inject constructor() :
    Mapper<DoubleDamageFrom, DoubleDamage> {
    override infix fun mapFrom(from: DoubleDamageFrom): DoubleDamage {
        return DoubleDamage(from.name, from.url)
    }
}