package com.harish.data.repository.datasource

import com.harish.core.Response
import com.harish.data.api.NetworkService
import com.harish.data.mapper.PokemonDescriptionDTOToDomainMapper
import com.harish.data.mapper.PokemonDetailDTOToDomainMapper
import com.harish.data.mapper.PokemonGenderDataMapper
import com.harish.data.mapper.PokemonListDTOMapper
import com.harish.data.mapper.PokemonWeaknessDataToDomainMapper
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonList
import com.harish.domain.model.PokemonWeakness
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    private val networkService: NetworkService,
    private val pokemonListDTOMapper: PokemonListDTOMapper,
    private val pokemonDescriptionDTOToDomainMapper: PokemonDescriptionDTOToDomainMapper,
    private val pokemonDetailDTOToDomainMapper: PokemonDetailDTOToDomainMapper,
    private val pokemonGenderDataMapper: PokemonGenderDataMapper,
    private val pokemonWeaknessDataToDomainMapper: PokemonWeaknessDataToDomainMapper

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
    }.flowOn(context = Dispatchers.IO)

    override suspend fun getPokemonDescriptions(pokemonId: Int): Flow<Response<PokemonDescription>> =
        flow<Response<PokemonDescription>> {
            try {
                val response = networkService.getPokemonDescription(pokemonId)
                if (response.isSuccessful) {
                    response.body()
                        ?.let {
                            emit(
                                Response.Success(
                                    pokemonDescriptionDTOToDomainMapper mapFrom it
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

        }.flowOn(Dispatchers.IO)


    override suspend fun getPokemonDetails(pokemonId: Int): Flow<Response<PokemonDetails>> = flow {
        try {
            val response = networkService.getPokemonDetail(pokemonId)
            if (response.isSuccessful) {
                response.body()
                    ?.let {
                        emit(
                            Response.Success(
                                pokemonDetailDTOToDomainMapper mapFrom it
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

    }.flowOn(Dispatchers.IO)

    override suspend fun getGenderData(genderId: Int): Flow<Response<PokemonGender>> =
        flow {
            try {
                val response = networkService.getGenderData(genderId)
                if (response.isSuccessful) {
                    response.body()
                        ?.let {
                            emit(
                                Response.Success(
                                    pokemonGenderDataMapper mapFrom it
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

        }.flowOn(Dispatchers.IO)

    override suspend fun getPokemonWeakness(pokemonId: Int): Flow<Response<PokemonWeakness>> = flow {
        try {
            val response = networkService.getPokemonWeakness(pokemonId)
            if (response.isSuccessful) {
                response.body()
                    ?.let {
                        emit(
                            Response.Success(
                                pokemonWeaknessDataToDomainMapper mapFrom it
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

    }.flowOn(Dispatchers.IO)


}

