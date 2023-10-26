package com.harish.domain.model


data class PokemonDetails(
    val abilities: List<AbilityModel>,
    val height: Int,
    val id: Int,
    val name: String,
    val stats: List<StatModel>,
    val types: List<TypeModel>,
    val weight: Int
)


data class AbilityModel(
    val ability: AbilitiesModel,
)

data class AbilitiesModel(
    val name: String,
)

data class StatModel(
    val stat: StatNameModel,
    val statData : Int
)

data class StatNameModel(
    val name: String,
)

data class TypeModel(
    val type: TypeNameModel
)

data class TypeNameModel(
    val name: String,
)
