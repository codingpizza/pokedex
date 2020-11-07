package com.codingpizza.pokedex.ui.detail

import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.data.model.Move
import com.codingpizza.pokedex.data.model.MoveX
import com.codingpizza.pokedex.databinding.PokemonMovesItemBinding

class PokemonMoveViewHolder(private val binding: PokemonMovesItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(pokemonMove: Move){
        with(binding){
            pokemonMoveName.text = pokemonMove.move?.name
        }
    }
}
