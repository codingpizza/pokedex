package com.codingpizza.pokedex.data.api

import com.codingpizza.pokedex.data.model.PokemonDetail
import com.codingpizza.pokedex.data.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {

    @GET("pokemon?limit=100&offset=0")
    suspend fun retrievePokemonList() : PokemonList

    @GET("pokemon/{pokemonName}")
    suspend fun retrievePokemonDetail(@Path("pokemonName") pokemonName : String) : PokemonDetail

}