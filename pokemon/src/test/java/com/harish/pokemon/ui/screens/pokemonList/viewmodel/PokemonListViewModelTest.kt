package com.harish.pokemon.ui.screens.pokemonList.viewmodel

import com.harish.core.Response
import com.harish.core.ViewState
import com.harish.domain.usecase.GetPokemonListUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonListViewModelTest {

    private val mockGetPokemonListUseCase: GetPokemonListUseCase = mockk(relaxed = true)
    private lateinit var pokemonListViewModel: PokemonListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var dispatcher = Dispatcher()

    @Before
    fun setup() {
        pokemonListViewModel = PokemonListViewModel(mockGetPokemonListUseCase)
    }

    @Test
    fun `getPokemonList on Success returns Success ViewState`() = runTest {
        val response = Response.Success(pokemonList)
        val mappedResponse = Response.Success(pokemonList)
        coEvery { mockGetPokemonListUseCase() } returns flowOf(response)

        pokemonListViewModel.getPokemonList()
        Assert.assertEquals(
            mappedResponse.data.pokemonList[0].name,
            (pokemonListViewModel.pokemonListStateFlow.value as ViewState.SuccessState).data[0].name
        )
    }

}