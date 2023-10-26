package com.harish.data.mapper

import com.harish.core.Mapper
import com.harish.data.model.AbilityDTO
import com.harish.data.model.AbilityXDTO
import com.harish.data.model.PokemonDetailsDTO
import com.harish.data.model.StatDTO
import com.harish.data.model.StatNameDTO
import com.harish.data.model.Type
import com.harish.data.model.TypeNameDTO
import com.harish.domain.model.AbilitiesModel
import com.harish.domain.model.AbilityModel
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.StatModel
import com.harish.domain.model.StatNameModel
import com.harish.domain.model.TypeModel
import com.harish.domain.model.TypeNameModel
import javax.inject.Inject

class PokemonDetailDTOToDomainMapper @Inject constructor(
    private val pokemonAbilityDataToDomainMapper: PokemonAbilityDataToDomainMapper,
    private val pokemonStatsDataToDomainMapper: PokemonStatsDataToDomainMapper,
    private val pokemonTypeDataToDomainMapper: PokemonTypeDataToDomainMapper
) : Mapper<PokemonDetailsDTO, PokemonDetails> {
    override infix fun mapFrom(from: PokemonDetailsDTO): PokemonDetails {
        return PokemonDetails(
            abilities = from.abilities.map { pokemonAbilityDataToDomainMapper mapFrom it },
            height = from.height,
            id = from.id,
            name = from.name,
            stats = from.statDTOS.map { pokemonStatsDataToDomainMapper mapFrom it },
            types = from.types.map { pokemonTypeDataToDomainMapper mapFrom it },
            weight = from.weight
        )
    }
}

class PokemonAbilityDataToDomainMapper @Inject constructor(
    private val pokemonAbilityItemDataToDomainMapper: PokemonAbilityItemDataToDomainMapper
) : Mapper<AbilityDTO, AbilityModel> {
    override infix fun mapFrom(from: AbilityDTO): AbilityModel {
        return AbilityModel(
            ability = pokemonAbilityItemDataToDomainMapper mapFrom from.ability
        )
    }
}

class PokemonAbilityItemDataToDomainMapper @Inject constructor() :
    Mapper<AbilityXDTO, AbilitiesModel> {
    override infix fun mapFrom(from: AbilityXDTO): AbilitiesModel {
        return AbilitiesModel(
            name = from.name
        )
    }
}

class PokemonStatsDataToDomainMapper @Inject constructor(
    private val pokemonStatsItemDataToDomainMapper: PokemonStatsItemDataToDomainMapper
) : Mapper<StatDTO, StatModel> {
    override infix fun mapFrom(from: StatDTO): StatModel {
        return StatModel(
            pokemonStatsItemDataToDomainMapper mapFrom from.stat, statData = from.baseStat
        )
    }
}

class PokemonStatsItemDataToDomainMapper @Inject constructor() :
    Mapper<StatNameDTO, StatNameModel> {
    override infix fun mapFrom(from: StatNameDTO): StatNameModel {
        return StatNameModel(
            name = from.name
        )
    }

}

class PokemonTypeDataToDomainMapper @Inject constructor(
    private val pokemonTypeItemDataToDomainMapper: PokemonTypeItemDataToDomainMapper
) : Mapper<Type, TypeModel> {
    override infix fun mapFrom(from: Type): TypeModel {
        return TypeModel(pokemonTypeItemDataToDomainMapper mapFrom from.type)
    }
}

class PokemonTypeItemDataToDomainMapper @Inject constructor() : Mapper<TypeNameDTO, TypeNameModel> {
    override infix fun mapFrom(from: TypeNameDTO): TypeNameModel {
        return TypeNameModel(
            name = from.name
        )
    }
}
