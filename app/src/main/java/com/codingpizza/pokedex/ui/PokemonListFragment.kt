package com.codingpizza.pokedex.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingpizza.pokedex.R
import com.codingpizza.pokedex.databinding.PokemonListFragmentBinding

class PokemonListFragment : Fragment() {

    private lateinit var viewModel: PokemonListViewModel

    private var adapter: PokemonListAdapter? = PokemonListAdapter { pokemonName ->
        Toast.makeText(context,"El pokemon seleccionado fue $pokemonName",Toast.LENGTH_SHORT)
            .show()
        findNavController().navigate(PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemonName))
    }

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
        viewModel.retrievePokemonList()
        viewModel.pokemonLiveData.observe(viewLifecycleOwner, Observer { pokemonList ->
            adapter?.submitList(pokemonList)
        })
        initializeUI()
    }

    private fun initializeUI() {
        binding?.apply {
            pokemonList.layoutManager = LinearLayoutManager(context)
            pokemonList.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}