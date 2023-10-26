package com.harish.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonWeaknessDTO(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations
)

@Serializable
data class DamageRelations(
    @SerialName("double_damage_from")
    val doubleDamageFrom: List<DoubleDamageFrom>
)

@Serializable
data class DoubleDamageFrom(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
