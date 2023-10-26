package com.harish.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailsDTO(
    @SerialName("abilities")
    val abilities: List<AbilityDTO>,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("stats")
    val statDTOS: List<StatDTO>,
    @SerialName("types")
    val types: List<Type>,
    @SerialName("weight")
    val weight: Int,
)



@Serializable
data class AbilityDTO(
    @SerialName("ability")
    val ability: AbilityXDTO,
    @SerialName("is_hidden")
    val is_hidden: Boolean,
    @SerialName("slot")
    val slot: Int
)


@Serializable
data class AbilityXDTO(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

@Serializable
data class StatDTO(
    @SerialName("base_stat")
    val baseStat: Int,
    @SerialName("effort")
    val effort: Int,
    @SerialName("stat")
    val stat: StatNameDTO
)

@Serializable
data class StatNameDTO(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

@Serializable
data class Type(
    @SerialName("slot")
    val slot: Int,
    @SerialName("type")
    val type: TypeNameDTO
)

@Serializable
data class TypeNameDTO(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)