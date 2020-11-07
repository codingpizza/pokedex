package com.codingpizza.pokedex.data.model


import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)