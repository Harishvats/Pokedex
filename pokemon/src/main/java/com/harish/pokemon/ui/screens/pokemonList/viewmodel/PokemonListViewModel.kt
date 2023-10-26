package com.harish.pokemon.ui.screens.pokemonList.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harish.core.Response
import com.harish.core.ViewState
import com.harish.domain.model.PokemonModel
import com.harish.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase) :
    ViewModel() {

    private val _pokemonListStateFlow =
        MutableStateFlow<ViewState<List<PokemonModel>>>(ViewState.LoadingState)
    val pokemonListStateFlow: StateFlow<ViewState<List<PokemonModel>>>
        get() = _pokemonListStateFlow

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            getPokemonListUseCase().collect() {
                when (it) {
                    is Response.Error -> _pokemonListStateFlow.value =
                        ViewState.ErrorState(it.message)

                    Response.Loading -> _pokemonListStateFlow.value = ViewState.LoadingState
                    is Response.Success -> _pokemonListStateFlow.value =
                        ViewState.SuccessState(it.data.pokemonList)
                }
            }
        }
    }



}