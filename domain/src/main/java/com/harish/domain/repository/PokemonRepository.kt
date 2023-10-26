package com.harish.domain.repository

import com.harish.core.Response
import com.harish.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    suspend fun getPokemonList(): Flow<Response<PokemonList>>

}