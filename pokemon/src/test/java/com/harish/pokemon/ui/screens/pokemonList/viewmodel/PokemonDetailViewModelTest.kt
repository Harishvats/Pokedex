package com.harish.pokemon.ui.screens.pokemonList.viewmodel

import com.harish.core.Response
import com.harish.core.ViewState
import com.harish.domain.usecase.GetPokemonDescriptionUseCase
import com.harish.domain.usecase.GetPokemonDetailsUseCase
import com.harish.domain.usecase.GetPokemonGenderUseCase
import com.harish.domain.usecase.GetPokemonWeaknessUseCase
import com.harish.pokemon.ui.screens.pokemonDetails.viewmodel.PokemonDetailsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonDetailViewModelTest {

    private val getPokemonDescriptionUseCase: GetPokemonDescriptionUseCase = mockk()
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase = mockk()
    private val getPokemonWeaknessUseCase: GetPokemonWeaknessUseCase = mockk()
    private val getPokemonGenderUseCase: GetPokemonGenderUseCase = mockk()

    private lateinit var pokemonDetailsViewModel: PokemonDetailsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var dispatcher = Dispatcher()

    @Before
    fun setup() {
        pokemonDetailsViewModel = PokemonDetailsViewModel(
            getPokemonDescriptionUseCase,
            getPokemonDetailsUseCase,
            getPokemonWeaknessUseCase,
            getPokemonGenderUseCase
        )
    }

    @Test
    fun `getPokemonDetails on Success returns Success ViewState`() = runTest {
        val response = Response.Success(pokemonDetails)
        val mappedResponse = Response.Success(pokemonDetails)
        coEvery { getPokemonDetailsUseCase(3) } returns flowOf(response)

        pokemonDetailsViewModel.getPokemonDetails(3)
        Assert.assertEquals(
            mappedResponse.data.name,
            (pokemonDetailsViewModel.pokemonDetailStateFlow.value as ViewState.SuccessState).data.name
        )
    }

    @Test
    fun `getPokemonDescription on Success returns Success ViewState`() = runTest {
        val response = Response.Success(pokemonDescription)
        val mappedResponse = Response.Success(pokemonDescription)
        coEvery { getPokemonDescriptionUseCase(3) } returns flowOf(response)

        pokemonDetailsViewModel.getPokemonDescription(3)
        Assert.assertEquals(
            mappedResponse.data.description,
            (pokemonDetailsViewModel.pokemonDescriptionStateFlow.value as ViewState.SuccessState).data.description
        )
    }

    @Test
    fun `getPokemonGender on Success returns Success ViewState`() = runTest {
        val response = Response.Success(pokemonGender)
        val mappedResponse = Response.Success(pokemonGender)
        coEvery { getPokemonGenderUseCase(3) } returns flowOf(response)

        pokemonDetailsViewModel.getPokemonGender(3)
        Assert.assertEquals(
            mappedResponse.data.pokemonSpeciesDetails,
            (pokemonDetailsViewModel.pokemonGenderStateFlow.value as ViewState.SuccessState).data.pokemonSpeciesDetails
        )
    }

    @Test
    fun `getPokemonWeakness on Success returns Success ViewState`() = runTest {
        val response = Response.Success(pokemonWeakness)
        val mappedResponse = Response.Success(pokemonWeakness)
        coEvery { getPokemonWeaknessUseCase(3) } returns flowOf(response)

        pokemonDetailsViewModel.getPokemonWeakness(3)
        Assert.assertEquals(
            mappedResponse.data.weakness,
            (pokemonDetailsViewModel.pokemonWeaknessStateFlow.value as ViewState.SuccessState).data.weakness
        )
    }

}