package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.repository

import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.domain.Pokemon
import java.util.*
import kotlin.concurrent.timerTask

class PokemonRepository {
    val pokemon = MutableLiveData(
        listOf(
            Pokemon(1, "Bulbasaur"),
            Pokemon(2, "Ivysaur"),
            Pokemon(3, "Venosaur"),
        )
    )

    init {
        val timer = Timer()

        timer.schedule(
            timerTask {
                val pokemonList = pokemon.value?.toMutableList()

                val charmander = Pokemon(4, "Charmander")
                pokemonList?.add(charmander)

                pokemon.postValue(pokemonList)
            },
            2000
        )
    }
}
