package com.codingpizza.pokedex.data.model


import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val pokemonListItems: List<PokemonListItem>?
)