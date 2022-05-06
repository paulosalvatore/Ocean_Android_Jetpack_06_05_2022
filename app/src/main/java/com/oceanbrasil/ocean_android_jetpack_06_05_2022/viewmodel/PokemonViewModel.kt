package com.oceanbrasil.ocean_android_jetpack_06_05_2022.viewmodel

import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.repository.PokemonRepository

class PokemonViewModel : ViewModel() {
    private val pokemonRepository = PokemonRepository()

    val pokemon = pokemonRepository.pokemon
}