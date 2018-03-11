package com.bkozajda.presentation.model

data class MovieViewModel(
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val posterPath: String
)