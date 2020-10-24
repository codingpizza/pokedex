package com.codingpizza.pokedex.data.api

import com.codingpizza.pokedex.data.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiService {

    //TODO Cambiar el limite a Query Param
    @GET("pokemon?limit=100&offset=0")
    suspend fun retrievePokemonList() : PokemonList


}