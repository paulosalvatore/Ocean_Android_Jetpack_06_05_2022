package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.domain.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRemoteDataSource {
    private val service: PokemonApiService

    val pokemon = MutableLiveData<List<Pokemon>>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonApiService::class.java)

        val call = service.findAllPokemon()

        call.enqueue(object : Callback<FindAllPokemonApiResponse> {
            override fun onResponse(
                call: Call<FindAllPokemonApiResponse>,
                response: Response<FindAllPokemonApiResponse>
            ) {
                Log.d("POKEMON_API", "Lista de pokémon carregada com sucesso.")

                val pokemonDomainList = response.body()?.results?.map {
                    Pokemon(it.name)
                }

                pokemon.postValue(pokemonDomainList)
            }

            override fun onFailure(call: Call<FindAllPokemonApiResponse>, t: Throwable) {
                Log.e("POKEMON_API", "Erro ao carregar lista de pokémon.", t)
                pokemon.postValue(null)
            }
        })
    }
}