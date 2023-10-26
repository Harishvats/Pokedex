package com.harish.data.repository.datasource

import com.harish.core.Response
import com.harish.data.IOResponseErrorMessage
import com.harish.data.api.NetworkService
import com.harish.data.errorCode
import com.harish.data.httpResponseErrorMessage
import com.harish.data.mapper.PokemonDescriptionDTOToDomainMapper
import com.harish.data.mapper.PokemonDetailDTOToDomainMapper
import com.harish.data.mapper.PokemonGenderDataMapper
import com.harish.data.mapper.PokemonListDTOMapper
import com.harish.data.mapper.PokemonWeaknessDataToDomainMapper
import com.harish.data.model.PokemonListDTO
import com.harish.data.pokemonList
import com.harish.data.pokemonListDTO
import com.harish.data.responseBody
import com.harish.data.responseErrorMessage
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import java.io.IOException

class GetPokemonListRemoteDataSourceTest {

    private val mockNetworkService: NetworkService = mockk()

    private lateinit var remoteDataSource: PokemonRemoteDataSource
    private val pokemonListDTOMapper: PokemonListDTOMapper = mockk()
    private val pokemonDescriptionDTOToDomainMapper: PokemonDescriptionDTOToDomainMapper = mockk()
    private val pokemonDetailDTOToDomainMapper: PokemonDetailDTOToDomainMapper = mockk()
    private val pokemonGenderDataMapper: PokemonGenderDataMapper = mockk()
    private val pokemonWeaknessDataToDomainMapper: PokemonWeaknessDataToDomainMapper = mockk()

    @Before
    fun setup() {
        remoteDataSource = PokemonRemoteDataSourceImpl(
            mockNetworkService,
            pokemonListDTOMapper,
            pokemonDescriptionDTOToDomainMapper,
            pokemonDetailDTOToDomainMapper,
            pokemonGenderDataMapper,
            pokemonWeaknessDataToDomainMapper
        )
    }

    @Test
    fun `getPokemonList on success returns flow of Success ApiResponse`() = runTest{

        coEvery { mockNetworkService.getPokemonList() } returns (retrofit2.Response.success(
            pokemonListDTO
        ))
        coEvery { (pokemonListDTOMapper.mapFrom(pokemonListDTO)) } returns (pokemonList)

        val result=remoteDataSource.getPokemonList().last()

        assertEquals(Response.Success(pokemonList), result)

    }

    @Test
    fun `getPokemonList() on error returns flow of Error ApiResponse`() = runTest {

        // Arrange
        val response = retrofit2.Response.error<PokemonListDTO>(
            errorCode, "".toResponseBody(responseBody)
        )
        coEvery { (mockNetworkService.getPokemonList()) } returns (response)

        // Act
        val result = remoteDataSource.getPokemonList().last()

        assertEquals(
            responseErrorMessage, (result as Response.Error).message
        )

    }

    @Test
    fun `getPokemonList() on HttpException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {
            val response = retrofit2.Response.error<PokemonListDTO>(
                errorCode, "".toResponseBody(responseBody)
            )
            coEvery {(mockNetworkService.getPokemonList())
            } throws HttpException(response)


            // Act
            val result = remoteDataSource.getPokemonList().last()

            assertEquals(
                Response.Error(httpResponseErrorMessage), result
            )
        }

    @Test
    fun `getPokemonList() on IOException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {

            coEvery {
                (mockNetworkService.getPokemonList())
            } throws IOException(IOResponseErrorMessage)

            // Act
            val result = remoteDataSource.getPokemonList().last()

            assertEquals(Response.Error(IOResponseErrorMessage), result)
        }

}