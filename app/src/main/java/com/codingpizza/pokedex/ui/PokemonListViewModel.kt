package com.codingpizza.pokedex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingpizza.pokedex.data.model.PokemonListItem
import com.codingpizza.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    private val repository : PokemonRepository = PokemonRepository()

    private val _pokemonLiveData = MutableLiveData<List<PokemonListItem>>()
    val pokemonLiveData : LiveData<List<PokemonListItem>> = _pokemonLiveData

    fun retrievePokemonList() {
        viewModelScope.launch {
            val result = repository.retrievePokemonList()
            _pokemonLiveData.value = result
        }
    }

}