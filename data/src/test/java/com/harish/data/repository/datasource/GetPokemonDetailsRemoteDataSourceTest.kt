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
import com.harish.data.model.PokemonDetailsDTO
import com.harish.data.model.PokemonListDTO
import com.harish.data.pokemonDetails
import com.harish.data.pokemonDetailsDTO
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

class GetPokemonDetailsRemoteDataSourceTest {

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
    fun `getPokemonDetails() on success returns flow of Success ApiResponse`() = runTest{

        coEvery { mockNetworkService.getPokemonDetail(1) } returns (retrofit2.Response.success(
            pokemonDetailsDTO
        ))
        coEvery { (pokemonDetailDTOToDomainMapper.mapFrom(pokemonDetailsDTO)) } returns (pokemonDetails)

        val result=remoteDataSource.getPokemonDetails(1).last()

        assertEquals(Response.Success(pokemonDetails), result)

    }

    @Test
    fun `getPokemonDetails() on error returns flow of Error ApiResponse`() = runTest {

        // Arrange
        val response = retrofit2.Response.error<PokemonDetailsDTO>(
            errorCode, "".toResponseBody(responseBody)
        )
        coEvery { (mockNetworkService.getPokemonDetail(1)) } returns (response)

        // Act
        val result = remoteDataSource.getPokemonDetails(1).last()

        assertEquals(
            responseErrorMessage, (result as Response.Error).message
        )

    }

    @Test
    fun `getPokemonDetails() on HttpException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {
            val response = retrofit2.Response.error<PokemonListDTO>(
                errorCode, "".toResponseBody(responseBody)
            )
            coEvery {(mockNetworkService.getPokemonDetail(1))
            } throws HttpException(response)


            // Act
            val result = remoteDataSource.getPokemonDetails(1).last()

            assertEquals(
                Response.Error(httpResponseErrorMessage), result
            )
        }

    @Test
    fun `getPokemonDetails() on IOException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {

            coEvery {
                (mockNetworkService.getPokemonDetail(1))
            } throws IOException(IOResponseErrorMessage)

            // Act
            val result = remoteDataSource.getPokemonDetails(1).last()

            assertEquals(Response.Error(IOResponseErrorMessage), result)
        }

}