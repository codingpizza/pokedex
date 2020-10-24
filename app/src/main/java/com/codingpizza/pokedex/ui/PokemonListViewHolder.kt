package com.codingpizza.pokedex.ui

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.data.model.PokemonListItem
import com.codingpizza.pokedex.databinding.PokemonListItemBinding

class PokemonListViewHolder(
    private val inflater: LayoutInflater,
    private val binding: PokemonListItemBinding = PokemonListItemBinding.inflate(inflater)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemonItem: PokemonListItem) {
        binding.apply {
            name.text = pokemonItem.name
        }
    }

}