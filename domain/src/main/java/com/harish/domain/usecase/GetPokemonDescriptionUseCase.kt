package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.model.PokemonDescription
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDescriptionUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(pokemonId:Int): Flow<Response<PokemonDescription>> = pokemonRepository.getPokemonDescription(pokemonId)
}