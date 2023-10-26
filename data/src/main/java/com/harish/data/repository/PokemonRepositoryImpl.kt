package com.harish.data.repository

import com.harish.core.Response
import com.harish.data.repository.datasource.PokemonRemoteDataSource
import com.harish.domain.model.PokemonList
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource) :
    PokemonRepository {
    override suspend fun getPokemonList(): Flow<Response<PokemonList>> =
        pokemonRemoteDataSource.getPokemonList()


}