package com.harish.data.repository.datasource

import com.harish.core.Response
import com.harish.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Flow<Response<PokemonList>>
    suspend fun getPokemonDetails(pokemonId: Int): Flow<Response<String>>
}