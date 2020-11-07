package com.codingpizza.pokedex.data.model


import com.google.gson.annotations.SerializedName

data class PokemonDetail(
    @SerializedName("abilities")
    val abilities: List<Ability>?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("moves")
    val moves: List<Move>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sprites")
    val sprites: Sprites?,
    @SerializedName("stats")
    val stats: List<Stat>?,
    @SerializedName("types")
    val types: List<Type>?,
    @SerializedName("weight")
    val weight: Int?
)