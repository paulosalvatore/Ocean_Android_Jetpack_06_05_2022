package com.oceanbrasil.ocean_android_jetpack_06_05_2022.model.datasource

data class FindAllPokemonApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<FindAllPokemonItemApi>
)
