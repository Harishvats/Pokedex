package com.harish.data.api

import com.harish.data.model.PokemonDescriptionDTO
import com.harish.data.model.PokemonDetailsDTO
import com.harish.data.model.PokemonGenderDTO
import com.harish.data.model.PokemonListDTO
import com.harish.data.model.PokemonWeaknessDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonListDTO>

    @GET("pokemon-species/{id}")
    suspend fun getPokemonDescription(@Path("id") id: Int): Response<PokemonDescriptionDTO>


    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int) : Response<PokemonDetailsDTO>

    @GET("gender/{genderId}")
    suspend fun getGenderData(@Path("genderId") id : Int) : Response<PokemonGenderDTO>

    @GET("type/{id}")
    suspend fun getPokemonWeakness(@Path("id") id : Int) : Response<PokemonWeaknessDTO>


}