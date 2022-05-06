package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.datasource

import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon")
    fun findAllPokemon(): Call<FindAllPokemonApiResponse>
}
