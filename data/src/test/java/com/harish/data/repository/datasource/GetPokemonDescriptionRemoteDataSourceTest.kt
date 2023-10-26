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
import com.harish.data.model.PokemonDescriptionDTO
import com.harish.data.model.PokemonListDTO
import com.harish.data.pokemonDescription
import com.harish.data.pokemonDescriptionDTO
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

class GetPokemonDescriptionRemoteDataSourceTest {

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
    fun `getPokemonDescriptions() on success returns flow of Success ApiResponse`() = runTest{

        coEvery { mockNetworkService.getPokemonDescription(1) } returns (retrofit2.Response.success(
            pokemonDescriptionDTO
        ))
        coEvery { (pokemonDescriptionDTOToDomainMapper.mapFrom(pokemonDescriptionDTO)) } returns (pokemonDescription)

        val result=remoteDataSource.getPokemonDescriptions(1).last()

        assertEquals(Response.Success(pokemonDescription), result)

    }

    @Test
    fun `getPokemonDescriptions() on error returns flow of Error ApiResponse`() = runTest {

        // Arrange
        val response = retrofit2.Response.error<PokemonDescriptionDTO>(
            errorCode, "".toResponseBody(responseBody)
        )
        coEvery { (mockNetworkService.getPokemonDescription(1)) } returns (response)

        // Act
        val result = remoteDataSource.getPokemonDescriptions(1).last()

        assertEquals(
            responseErrorMessage, (result as Response.Error).message
        )

    }

    @Test
    fun `getPokemonDescriptions() on HttpException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {
            val response = retrofit2.Response.error<PokemonListDTO>(
                errorCode, "".toResponseBody(responseBody)
            )
            coEvery {(mockNetworkService.getPokemonDescription(1))
            } throws HttpException(response)


            // Act
            val result = remoteDataSource.getPokemonDescriptions(1).last()

            assertEquals(
                Response.Error(httpResponseErrorMessage), result
            )
        }

    @Test
    fun `getPokemonDescriptions() on IOException in api call returns flow of Error ApiResponse with exception message`() =
        runTest {

            coEvery {
                (mockNetworkService.getPokemonDescription(1))
            } throws IOException(IOResponseErrorMessage)

            // Act
            val result = remoteDataSource.getPokemonDescriptions(1).last()

            assertEquals(Response.Error(IOResponseErrorMessage), result)
        }

}