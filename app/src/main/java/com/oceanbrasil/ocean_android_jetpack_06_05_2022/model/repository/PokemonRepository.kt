package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.repository

import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.domain.Pokemon

class PokemonRepository {
    val pokemon = MutableLiveData(
        listOf(
            Pokemon("Bulbasaur"),
            Pokemon("Ivysaur"),
            Pokemon("Venusaur"),
        )
    )

    fun create(newPokemon: Pokemon) {
        val pokemonList = pokemon.value?.toMutableList()
        pokemonList?.add(newPokemon)

        pokemon.postValue(pokemonList)
    }
}
