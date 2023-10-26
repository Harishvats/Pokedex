package com.harish.data.api

import com.harish.data.model.PokemonListDTO
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonListDTO>


}