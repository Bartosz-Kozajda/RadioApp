package com.bkozajda.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val posterPath: String
)