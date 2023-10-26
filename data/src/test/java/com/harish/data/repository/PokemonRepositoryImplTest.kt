package com.harish.data.repository

import com.harish.core.Response
import com.harish.data.pokemonDescription
import com.harish.data.pokemonDetails
import com.harish.data.pokemonGender
import com.harish.data.pokemonList
import com.harish.data.pokemonWeakness
import com.harish.data.repository.datasource.PokemonRemoteDataSource
import com.harish.domain.model.PokemonList
import com.harish.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PokemonRepositoryImplTest {
    private val mockPokemonRemoteDataSource: PokemonRemoteDataSource = mockk()

    private lateinit var repository: PokemonRepository

    @Before
    fun setup() {
        repository = PokemonRepositoryImpl(mockPokemonRemoteDataSource)
    }

    @Test
    fun `getPokemonList on getting result from PokemonRemoteDataSource returns pokemon list as flow of Success ApiResponse`() =
        runTest {
            // Arrange
            val expectedResponse = Response.Success(pokemonList)
            coEvery { (mockPokemonRemoteDataSource.getPokemonList()) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            // Act
            val resultFlow = repository.getPokemonList()

            // Assert
            val resultList: List<Response<PokemonList>> = resultFlow.toList()
            assertEquals(listOf(expectedResponse), resultList)
        }

    @Test
    fun `getPokemonDescription on getting result from PokemonRemoteDataSource returns pokemon description as flow of Success ApiResponse`() =
        runTest {
            // Arrange
            val expectedResponse = Response.Success(pokemonDescription)
            coEvery { (mockPokemonRemoteDataSource.getPokemonDescriptions(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            // Act
            val resultFlow = repository.getPokemonDescription(1).last()

            // Assert
            assertEquals(expectedResponse, resultFlow)
        }


    @Test
    fun `getPokemonDetails on getting result from PokemonRemoteDataSource returns pokemon details as flow of Success ApiResponse`() =
        runTest {
            // Arrange
            val expectedResponse = Response.Success(pokemonDetails)
            coEvery { (mockPokemonRemoteDataSource.getPokemonDetails(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            // Act
            val resultFlow = repository.getPokemonDetails(1).last()

            // Assert
            assertEquals(expectedResponse, resultFlow)
        }

    @Test
    fun `getPokemonGender on getting result from PokemonRemoteDataSource returns pokemon gender as flow of Success ApiResponse`() =
        runTest {
            // Arrange
            val expectedResponse = Response.Success(pokemonGender)
            coEvery { (mockPokemonRemoteDataSource.getGenderData(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            // Act
            val resultFlow = repository.getPokemonGender(1).last()

            // Assert
            assertEquals(expectedResponse, resultFlow)
        }

    @Test
    fun `getPokemonWeakness on getting result from PokemonRemoteDataSource returns pokemon weakness as flow of Success ApiResponse`() =
        runTest {
            // Arrange
            val expectedResponse = Response.Success(pokemonWeakness)
            coEvery { (mockPokemonRemoteDataSource.getPokemonWeakness(1)) } returns (flow {
                emit(
                    expectedResponse
                )
            })

            // Act
            val resultFlow = repository.getPokemonWeakness(1).last()

            // Assert
            assertEquals(expectedResponse, resultFlow)
        }




}