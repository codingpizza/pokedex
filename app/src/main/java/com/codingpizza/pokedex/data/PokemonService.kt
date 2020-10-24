package com.codingpizza.pokedex.data

import com.codingpizza.pokedex.data.api.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonService {

    fun getPokemonService() : PokemonApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PokemonApiService::class.java)
    }
}