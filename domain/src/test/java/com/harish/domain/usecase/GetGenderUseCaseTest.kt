package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetGenderUseCaseTest{

    private val mockMovieRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonGenderUseCase: GetPokemonGenderUseCase

    @Before
    fun setup() {
        getPokemonGenderUseCase = GetPokemonGenderUseCase(mockMovieRepository)
    }

    @Test
    fun `GetPokemonGenderUseCase on Success result from repository returns pokemon details as Success APiResponse`() =
        runTest {
            val expectedResponse = Response.Success(pokemonGender)
            coEvery { (mockMovieRepository.getPokemonGender(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            val result = getPokemonGenderUseCase(1)

            result.collect { response ->
                assert(response is Response.Success)
                val data = (response as Response.Success).data
                assert(data.pokemonSpeciesDetails == expectedResponse.data.pokemonSpeciesDetails)
            }
        }

}