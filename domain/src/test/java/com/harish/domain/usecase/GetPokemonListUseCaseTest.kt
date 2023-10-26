package com.harish.domain.usecase

import com.harish.core.Response
import com.harish.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPokemonListUseCaseTest{

    private val mockMovieRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonListUseCaseTest: GetPokemonListUseCase

    @Before
    fun setup() {
        getPokemonListUseCaseTest = GetPokemonListUseCase(mockMovieRepository)
    }

    @Test
    fun `GetPokemonListUseCase on Success result from repository returns pokemon details as Success APiResponse`() =
        runTest {
            val expectedResponse = Response.Success(pokemonList)
            coEvery { (mockMovieRepository.getPokemonList()) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            val result = getPokemonListUseCaseTest()

            result.collect { response ->
                assert(response is Response.Success)
                val data = (response as Response.Success).data
                assert(data.pokemonList[0].name == expectedResponse.data.pokemonList[0].name)
            }
        }

}