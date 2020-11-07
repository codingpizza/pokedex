package com.codingpizza.pokedex.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.codingpizza.pokedex.R
import com.codingpizza.pokedex.data.model.PokemonDetail
import com.codingpizza.pokedex.databinding.PokemonDetailFragmentBinding
import com.codingpizza.pokedex.ui.PokemonListViewModel
import com.google.android.material.chip.Chip
import java.util.*

class PokemonDetailFragment : Fragment() {

    private lateinit var viewModel: PokemonDetailViewModel
    private var binding: PokemonDetailFragmentBinding? = null

    private val args: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonDetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonDetailViewModel::class.java)
        viewModel.pokemonDetailLiveData.observe(
            viewLifecycleOwner,
            Observer(::setPokemonInformation)
        )
        viewModel.retrievePokemonDetail(args.pokemonName)
        binding?.apply {
            pokemonTitle.text = args.pokemonName?.toUpperCase(Locale.getDefault())
        }
    }

    private fun setPokemonInformation(pokemonDetail: PokemonDetail) {
        binding?.apply {
            pokemonImage.load(pokemonDetail.sprites?.other?.officialArtwork?.frontDefault)
            pokemonDetail.types?.forEach { type ->
                val chip = Chip(requireContext())
                chip.text = type.type?.name
                pokemonTypesChips.addView(chip)
            }
            pokemonWeightValue.text = pokemonDetail.weight.toString()
            val pokemonMoveAdapter = PokemonMoveAdapter()
            pokemonMoveAdapter.submitList(pokemonDetail.moves ?: emptyList())
            moveList.layoutManager = LinearLayoutManager(context)
            moveList.adapter = pokemonMoveAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}