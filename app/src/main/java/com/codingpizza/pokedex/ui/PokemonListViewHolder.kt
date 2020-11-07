package com.codingpizza.pokedex.ui

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.codingpizza.pokedex.data.model.PokemonListItem
import com.codingpizza.pokedex.databinding.PokemonListItemBinding

class PokemonListViewHolder(
    private val binding: PokemonListItemBinding,
    private val onItemClicked: (String?) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemonItem: PokemonListItem) {
        binding.apply {
            name.text = pokemonItem.name
            pokemonImage.load(pokemonItem.obtainPokemonImageUrl())
            pokemonCard.setOnClickListener { onItemClicked(pokemonItem.name) }
        }
    }

}