package com.codingpizza.pokedex.ui

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.databinding.PokemonListItemBinding
import com.codingpizza.pokedex.domain.model.PokemonItem

class PokemonListViewHolder(
    private val inflater: LayoutInflater,
    private val binding: PokemonListItemBinding = PokemonListItemBinding.inflate(inflater)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemonItem: PokemonItem) {
        binding.apply {
            name.text = pokemonItem.pokemonName
        }
    }

}