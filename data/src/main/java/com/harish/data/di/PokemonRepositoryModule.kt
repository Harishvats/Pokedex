package com.harish.data.di

import com.harish.data.repository.PokemonRepositoryImpl
import com.harish.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonRepositoryModule {
    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}