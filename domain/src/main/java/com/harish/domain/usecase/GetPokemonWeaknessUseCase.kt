package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.model.PokemonWeakness
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonWeaknessUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(pokemonId: Int): Flow<Response<PokemonWeakness>> =
        pokemonRepository.getPokemonWeakness(pokemonId)
}