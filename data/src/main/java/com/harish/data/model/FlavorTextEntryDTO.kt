package com.harish.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextEntryDTO(
    @SerialName("flavor_text")
    val flavorText: String,
)
