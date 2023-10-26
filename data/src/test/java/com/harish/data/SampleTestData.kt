package com.harish.data

import com.harish.data.model.DamageRelations
import com.harish.data.model.DoubleDamageFrom
import com.harish.data.model.EggGroupDTO
import com.harish.data.model.FlavorTextEntryDTO
import com.harish.data.model.PokemonDTO
import com.harish.data.model.PokemonDescriptionDTO
import com.harish.data.model.PokemonDetailsDTO
import com.harish.data.model.PokemonGenderDTO
import com.harish.data.model.PokemonListDTO
import com.harish.data.model.PokemonSpeciesDTO
import com.harish.data.model.PokemonSpeciesDetailDTO
import com.harish.data.model.PokemonWeaknessDTO
import com.harish.domain.model.DoubleDamage
import com.harish.domain.model.EggGroup
import com.harish.domain.model.FlavorTextEntry
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonModel
import com.harish.domain.model.PokemonSpecies
import com.harish.domain.model.PokemonWeakness
import okhttp3.MediaType.Companion.toMediaTypeOrNull


const val errorCode = 404
val responseBody = "application/json".toMediaTypeOrNull()
const val responseErrorMessage = "Response.error()"
const val httpResponseErrorMessage = "HTTP 404 Response.error()"
const val IOResponseErrorMessage = "IO Error"

val pokemonDTO = PokemonDTO(
    "Pikacchu", "testurl.com"
)

val pokemonModel = PokemonModel(
    "Pikacchu", "testurl.com"
)

val pokemonListDataModel = PokemonListDTO(0, "next", listOf(pokemonDTO))
val pokemonList = PokemonList(listOf(pokemonModel))
val pokemonListDTO = PokemonListDTO(0,"",listOf(pokemonDTO))

val pokemonDetailsDTO = PokemonDetailsDTO(
    emptyList(),
    3, 3,
    "Pikachuu",
    emptyList(),
    emptyList(),
    13,
)


val pokemonDetails = PokemonDetails(
    emptyList(),
    3, 3,
    "Pikachuu",
    emptyList(),
    emptyList(),
    13,
)

val pokemonEggGroupDTO = EggGroupDTO("egg", "url")
val pokemonEggGroup = EggGroup("egg", "url")

val pokemonDescriptionDTO =
    PokemonDescriptionDTO(emptyList(), listOf(FlavorTextEntryDTO("description")))

val pokemonDescription = PokemonDescription(emptyList(), "description")

val pokemonGenderDTO = PokemonGenderDTO(3, "Pikachuu", emptyList())
val pokemonGender = PokemonGender(emptyList())

val pokemonWeaknessDTO = PokemonWeaknessDTO(DamageRelations(emptyList()))
val pokemonWeakness = PokemonWeakness(emptyList())

val pokemonDescriptionFlavorTextEntryDTO = FlavorTextEntryDTO("flavourText")
val pokemonDescriptionFlavorTextEntry = FlavorTextEntry("flavourText")
val doubleDamageFrom = DoubleDamageFrom("name", "url")
val doubleDamage = DoubleDamage("name", "url")

val pokemonSpecies=PokemonSpecies("name","url")
val pokemonSpeciesDTO=PokemonSpeciesDTO("name","url")
val pokemonSpeciesDetailDTO=PokemonSpeciesDetailDTO(pokemonSpeciesDTO,1)
val pokemonSpeciesDetail=PokemonSpecies("name","url")