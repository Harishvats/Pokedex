package com.harish.pokemon.ui.screens.pokemonDetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harish.core.Response
import com.harish.core.ViewState
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonGender
import com.harish.domain.model.PokemonWeakness
import com.harish.domain.usecase.GetPokemonDescriptionUseCase
import com.harish.domain.usecase.GetPokemonDetailsUseCase
import com.harish.domain.usecase.GetPokemonGenderUseCase
import com.harish.domain.usecase.GetPokemonWeaknessUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDescriptionUseCase: GetPokemonDescriptionUseCase,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val getPokemonWeaknessUseCase: GetPokemonWeaknessUseCase,
    private val getPokemonGenderUseCase: GetPokemonGenderUseCase
) : ViewModel() {

    private val _pokemonDescriptionStateFlow =
        MutableStateFlow<ViewState<PokemonDescription>>(ViewState.LoadingState)
    val pokemonDescriptionStateFlow: StateFlow<ViewState<PokemonDescription>>
        get() = _pokemonDescriptionStateFlow

    private val _pokemonDetailStateFlow =
        MutableStateFlow<ViewState<PokemonDetails>>(ViewState.LoadingState)
    val pokemonDetailStateFlow: StateFlow<ViewState<PokemonDetails>>
        get() = _pokemonDetailStateFlow


    private val _pokemonGenderStateFlow =
        MutableStateFlow<ViewState<PokemonGender>>(ViewState.LoadingState)
    val pokemonGenderStateFlow: StateFlow<ViewState<PokemonGender>>
        get() = _pokemonGenderStateFlow


    private val _pokemonWeaknessStateFlow =
        MutableStateFlow<ViewState<PokemonWeakness>>(ViewState.LoadingState)
    val pokemonWeaknessStateFlow: StateFlow<ViewState<PokemonWeakness>>
        get() = _pokemonWeaknessStateFlow


    fun getPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            getPokemonDetailsUseCase(pokemonId).collect() {
                when (it) {
                    is Response.Error -> _pokemonDetailStateFlow.value =
                        ViewState.ErrorState(it.message)

                    Response.Loading -> _pokemonDetailStateFlow.value = ViewState.LoadingState
                    is Response.Success -> _pokemonDetailStateFlow.value =
                        ViewState.SuccessState(it.data)
                }
            }
        }
    }

    fun getPokemonDescription(pokemonId: Int) {
        viewModelScope.launch {
            getPokemonDescriptionUseCase(pokemonId).collect() {
                when (it) {
                    is Response.Error -> _pokemonDescriptionStateFlow.value =
                        ViewState.ErrorState(it.message)

                    Response.Loading -> _pokemonDescriptionStateFlow.value = ViewState.LoadingState
                    is Response.Success -> _pokemonDescriptionStateFlow.value =
                        ViewState.SuccessState(it.data)
                }
            }
        }
    }

    fun getPokemonGender(pokemonId: Int) {
        viewModelScope.launch {
            getPokemonGenderUseCase(pokemonId).collect() {
                when (it) {
                    is Response.Error -> _pokemonGenderStateFlow.value =
                        ViewState.ErrorState(it.message)

                    Response.Loading -> _pokemonGenderStateFlow.value = ViewState.LoadingState
                    is Response.Success -> _pokemonGenderStateFlow.value =
                        ViewState.SuccessState(it.data)
                }
            }
        }
    }

    fun getPokemonWeakness(pokemonId: Int) {
        viewModelScope.launch {
            getPokemonWeaknessUseCase(pokemonId).collect() {
                when (it) {
                    is Response.Error -> _pokemonWeaknessStateFlow.value =
                        ViewState.ErrorState(it.message)

                    Response.Loading -> _pokemonWeaknessStateFlow.value = ViewState.LoadingState
                    is Response.Success -> _pokemonWeaknessStateFlow.value =
                        ViewState.SuccessState(it.data)
                }
            }
        }
    }


}