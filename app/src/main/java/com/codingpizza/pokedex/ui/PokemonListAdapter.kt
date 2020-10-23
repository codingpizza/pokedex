package com.codingpizza.pokedex.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.domain.model.PokemonItem

class PokemonListAdapter : RecyclerView.Adapter<PokemonListViewHolder>() {

    private val pokemonList: MutableList<PokemonItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder =
        PokemonListViewHolder(LayoutInflater.from(parent.context))

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) =
        holder.bind(pokemonList[position])

    fun submitList(list: List<PokemonItem>) {
        pokemonList.clear()
        pokemonList.addAll(list)
    }
}