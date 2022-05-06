package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.repository

import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.datasource.PokemonRemoteDataSource
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.domain.Pokemon

class PokemonRepository {
    private val pokemonRemoteDataSource = PokemonRemoteDataSource()

    val pokemon = pokemonRemoteDataSource.pokemon

    fun create(newPokemon: Pokemon) {
        val pokemonList = pokemon.value?.toMutableList()
        pokemonList?.add(newPokemon)

        pokemon.postValue(pokemonList)
    }
}
