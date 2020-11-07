package com.codingpizza.pokedex.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingpizza.pokedex.data.model.PokemonDetail
import com.codingpizza.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {

    private val _pokemonDetailLiveData = MutableLiveData<PokemonDetail>()
    val pokemonDetailLiveData : LiveData<PokemonDetail> = _pokemonDetailLiveData

    private val repository : PokemonRepository = PokemonRepository()

    fun retrievePokemonDetail(name: String?) {
        name?.let { nonNullableName ->
            viewModelScope.launch {
                val response = repository.retrievePokemonDetail(nonNullableName)
                _pokemonDetailLiveData.value = response
            }
        }
    }

}