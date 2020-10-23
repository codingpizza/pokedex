package com.codingpizza.pokedex.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingpizza.pokedex.R
import com.codingpizza.pokedex.databinding.PokemonListFragmentBinding
import com.codingpizza.pokedex.domain.model.PokemonItem

class PokemonListFragment : Fragment() {

    private lateinit var viewModel: PokemonListViewModel
    private var adapter: PokemonListAdapter? = null
    private var binding: PokemonListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        initializeUI()
    }

    private fun initializeUI() {
        binding?.apply {
            val list = listOf(PokemonItem("Pikachu"),
                PokemonItem("Charmander"),
                PokemonItem("Mew"),
                PokemonItem("Jigglypuff"),
                PokemonItem("Charizard")
            )
            adapter = PokemonListAdapter().also { pokemonListAdapter -> pokemonListAdapter.submitList(list) }
            pokemonList.layoutManager = LinearLayoutManager(context)
            pokemonList.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}