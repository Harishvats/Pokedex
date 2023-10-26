package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPokemonDescriptionUseCaseTest{

    private val mockMovieRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonDescriptionUseCase: GetPokemonDescriptionUseCase

    @Before
    fun setup() {
        getPokemonDescriptionUseCase = GetPokemonDescriptionUseCase(mockMovieRepository)
    }

    @Test
    fun `GetPokemonDescriptionUseCase on Success result from repository returns pokemon description as Success APiResponse`() =
        runTest {
            val expectedResponse = Response.Success(pokemonDescription)
            coEvery { (mockMovieRepository.getPokemonDescription(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            val result = getPokemonDescriptionUseCase(1)

            result.collect { response ->
                assert(response is Response.Success)
                val data = (response as Response.Success).data
                assert(data.description == expectedResponse.data.description)
            }
        }

}