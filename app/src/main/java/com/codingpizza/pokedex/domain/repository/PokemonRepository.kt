package com.codingpizza.pokedex.domain.repository

import com.codingpizza.pokedex.data.PokemonService
import com.codingpizza.pokedex.data.model.PokemonDetail
import com.codingpizza.pokedex.data.model.PokemonListItem

class PokemonRepository {

    private val pokemonService: PokemonService = PokemonService

    suspend fun retrievePokemonList(): List<PokemonListItem> {
        val response = pokemonService.getPokemonService().retrievePokemonList()
        return response.pokemonListItems ?: emptyList()
    }

    suspend fun retrievePokemonDetail(name: String): PokemonDetail {
        return pokemonService.getPokemonService().retrievePokemonDetail(name)
    }

}