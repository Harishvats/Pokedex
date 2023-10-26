package com.harish.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDescriptionDTO(
    @SerialName("egg_groups")
    val eggGroups: List<EggGroupDTO>,

    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntryDTO>,

    )