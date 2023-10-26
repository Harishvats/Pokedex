package com.harish.domain.model


data class PokemonWeakness(
    val weakness: List<DoubleDamage>,
)
data class DoubleDamage(
    val name: String,
    val url: String
)