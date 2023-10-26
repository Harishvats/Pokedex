package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.model.PokemonGender
import com.harish.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonGenderUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(genderId:Int): Flow<Response<PokemonGender>> = pokemonRepository.getPokemonGender(genderId)
}