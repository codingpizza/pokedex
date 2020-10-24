package com.codingpizza.pokedex.domain.repository

import android.util.Log
import com.codingpizza.pokedex.data.PokemonService
import com.codingpizza.pokedex.data.model.PokemonList
import com.codingpizza.pokedex.data.model.PokemonListItem

class PokemonRepository {

    private val pokemonService: PokemonService = PokemonService

    suspend fun retrievePokemonList() : List<PokemonListItem> {
        val response = pokemonService.getPokemonService().retrievePokemonList()
        return response.pokemonListItems ?: emptyList()
//        return if (response.isSuccessful){
//            response.body()?.pokemonListItems ?: emptyList()
//        } else {
//            Log.d("Pokemon Repository:","Ha ocurrido un error en la llamada: ${response.code()}")
//            emptyList()
//        }
    }

}