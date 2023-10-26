package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.model.PokemonList
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(): Flow<Response<PokemonList>> = pokemonRepository.getPokemonList()

}