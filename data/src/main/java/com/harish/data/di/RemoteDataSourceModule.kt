package com.harish.data.di

import com.harish.data.repository.datasource.PokemonRemoteDataSource
import com.harish.data.repository.datasource.PokemonRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindMovieRemoteDataSource(remoteDataSourceImpl: PokemonRemoteDataSourceImpl): PokemonRemoteDataSource
}