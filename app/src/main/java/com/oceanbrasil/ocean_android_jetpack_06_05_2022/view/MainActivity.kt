package com.oceanbrasil.ocean_android_jetpack_06_05_2022.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.R
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.domain.Pokemon
import com.oceanbrasil.ocean_android_jetpack_06_05_2022.viewmodel.PokemonViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        val pokemon = pokemonViewModel.pokemon

        // Exibição de pokémon
        val textView = findViewById<TextView>(R.id.textView)

        pokemon.observe(this) { pokemonList ->
            textView.text = ""

            pokemonList.forEach {
                textView.append("${it.name}\n")
            }
        }

        // Criação de pokémon
        val etPokemonName = findViewById<EditText>(R.id.etPokemonName)
        val btAddPokemon = findViewById<Button>(R.id.btAddPokemon)

        btAddPokemon.setOnClickListener {
            val name = etPokemonName.text.toString()

            if (name.isNotBlank()) {
                pokemonViewModel.create(Pokemon(name))
                etPokemonName.setText("")
            } else {
                etPokemonName.error = "Digite um nome válido!"
            }
        }
    }
}
