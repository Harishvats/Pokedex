package com.harish.data.repository

import com.harish.core.Response
import com.harish.data.repository.datasource.PokemonRemoteDataSource
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonWeakness
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource) :
    PokemonRepository {
    override suspend fun getPokemonList(): Flow<Response<PokemonList>> =
        pokemonRemoteDataSource.getPokemonList()

    override suspend fun getPokemonDescription(pokemonId: Int): Flow<Response<PokemonDescription>> =
        pokemonRemoteDataSource.getPokemonDescriptions(pokemonId)


    override suspend fun getPokemonDetails(pokemonId: Int): Flow<Response<PokemonDetails>> =
        pokemonRemoteDataSource.getPokemonDetails(pokemonId)

    override suspend fun getPokemonGender(genderId: Int): Flow<Response<PokemonGender>> =
        pokemonRemoteDataSource.getGenderData(genderId)

    override suspend fun getPokemonWeakness(pokemonId: Int): Flow<Response<PokemonWeakness>> =
        pokemonRemoteDataSource.getPokemonWeakness(pokemonId)

}