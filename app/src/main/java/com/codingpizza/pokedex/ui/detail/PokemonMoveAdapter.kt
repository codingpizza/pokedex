package com.codingpizza.pokedex.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.data.model.Move
import com.codingpizza.pokedex.databinding.PokemonMovesItemBinding

class PokemonMoveAdapter : RecyclerView.Adapter<PokemonMoveViewHolder>() {

    private val pokemonMoveList: MutableList<Move> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonMoveViewHolder =
        PokemonMoveViewHolder(
            PokemonMovesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PokemonMoveViewHolder, position: Int) =
        holder.bind(pokemonMoveList[position])

    override fun getItemCount(): Int = pokemonMoveList.size

    fun submitList(list: List<Move>) {
        pokemonMoveList.clear()
        pokemonMoveList.addAll(list)
        notifyDataSetChanged()
    }

}