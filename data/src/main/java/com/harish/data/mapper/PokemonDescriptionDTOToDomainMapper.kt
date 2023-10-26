package com.harish.data.mapper

import com.harish.core.Mapper
import com.harish.data.model.EggGroupDTO
import com.harish.data.model.FlavorTextEntryDTO
import com.harish.data.model.PokemonDescriptionDTO
import com.harish.domain.model.EggGroup
import com.harish.domain.model.FlavorTextEntry
import com.harish.domain.model.PokemonDescription
import javax.inject.Inject

class PokemonDescriptionDTOToDomainMapper @Inject constructor(
    private val eggGroupMapper: PokemonDescriptionEggGroupMapper,
) : Mapper<PokemonDescriptionDTO, PokemonDescription> {
    override infix fun mapFrom(from: PokemonDescriptionDTO): PokemonDescription {
        return PokemonDescription(
            eggGroups = from.eggGroups.map { data -> eggGroupMapper mapFrom data },
            description = combinedDescription(from.flavorTextEntries)
        )
    }
}

private fun combinedDescription(flavourText: List<FlavorTextEntryDTO>): String {
    var description = ""
    flavourText.forEach {
        description += it.flavorText
    }
    return description
}


class PokemonDescriptionEggGroupMapper @Inject constructor() : Mapper<EggGroupDTO, EggGroup> {
    override infix fun mapFrom(from: EggGroupDTO): EggGroup {
        return EggGroup(name = from.name, url = from.url)
    }

}

class PokemonDescriptionFlavourTextMapper @Inject constructor() :
    Mapper<FlavorTextEntryDTO, FlavorTextEntry> {
    override infix fun mapFrom(from: FlavorTextEntryDTO): FlavorTextEntry {
        return FlavorTextEntry(flavorText = from.flavorText)
    }
}