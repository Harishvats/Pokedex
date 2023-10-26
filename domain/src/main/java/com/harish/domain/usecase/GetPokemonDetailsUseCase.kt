package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.model.PokemonDetails
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(pokemonId:Int): Flow<Response<PokemonDetails>> = pokemonRepository.getPokemonDetails(pokemonId)
}