package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPokemonWeaknessUseCaseTest{

    private val mockMovieRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonWeaknessUseCase: GetPokemonWeaknessUseCase

    @Before
    fun setup() {
        getPokemonWeaknessUseCase = GetPokemonWeaknessUseCase(mockMovieRepository)
    }

    @Test
    fun `GetPokemonGenderUseCase on Success result from repository returns pokemon details as Success APiResponse`() =
        runTest {
            val expectedResponse = Response.Success(pokemonWeakness)
            coEvery { (mockMovieRepository.getPokemonWeakness(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            val result = getPokemonWeaknessUseCase(1)

            result.collect { response ->
                assert(response is Response.Success)
                val data = (response as Response.Success).data
                assert(data.weakness == expectedResponse.data.weakness)
            }
        }

}