package com.harish.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)