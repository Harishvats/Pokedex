package com.harish.data.repository.datasource

import com.harish.core.Response
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonWeakness
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Flow<Response<PokemonList>>
    suspend fun getPokemonDescriptions(pokemonId: Int): Flow<Response<PokemonDescription>>
    suspend fun getPokemonDetails(pokemonId: Int): Flow<Response<PokemonDetails>>
    suspend fun getGenderData(genderId: Int): Flow<Response<PokemonGender>>
    suspend fun getPokemonWeakness(pokemonId: Int): Flow<Response<PokemonWeakness>>

}