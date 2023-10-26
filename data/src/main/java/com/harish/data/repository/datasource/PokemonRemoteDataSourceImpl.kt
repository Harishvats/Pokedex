package com.harish.data.repository.datasource

import com.harish.core.Response
import com.harish.data.api.NetworkService
import com.harish.data.mapper.PokemonListDTOMapper
import com.harish.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    private val networkService: NetworkService,
    private val pokemonListDTOMapper: PokemonListDTOMapper

) : PokemonRemoteDataSource {
    override suspend fun getPokemonList(): Flow<Response<PokemonList>> = flow {
        try {
            val response = networkService.getPokemonList()
            if (response.isSuccessful) {
                response.body()
                    ?.let {
                        emit(
                            Response.Success(
                                pokemonListDTOMapper mapFrom it
                            )
                        )
                    }
            } else {
                emit(Response.Error(response.message()))
            }
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: ""))

        } catch (e: IOException) {
            emit(Response.Error(e.localizedMessage ?: ""))

        }
    }

    override suspend fun getPokemonDetails(movieId: Int): Flow<Response<String>> {
        TODO("Not yet implemented")
    }


}

