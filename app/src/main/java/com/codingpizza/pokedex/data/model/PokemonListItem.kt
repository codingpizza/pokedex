package com.codingpizza.pokedex.data.model


import com.codingpizza.pokedex.data.constants.POKEMON_BASE_URL
import com.google.gson.annotations.SerializedName

data class PokemonListItem(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
) {

    fun obtainPokemonImageUrl(): String {
        val imageUrl = url?.substringBeforeLast("/")?.substringAfterLast("/").plus(".png")
        return POKEMON_BASE_URL + imageUrl
    }
}