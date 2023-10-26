package com.harish.domain.repository

import com.harish.core.Response
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonWeakness
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    suspend fun getPokemonList(): Flow<Response<PokemonList>>
    suspend fun getPokemonDescription(pokemonId:Int): Flow<Response<PokemonDescription>>
    suspend fun getPokemonDetails(pokemonId:Int): Flow<Response<PokemonDetails>>
    suspend fun getPokemonGender(genderId:Int): Flow<Response<PokemonGender>>
    suspend fun getPokemonWeakness(pokemonId:Int): Flow<Response<PokemonWeakness>>

}