package com.bkozajda.remote.model

data class MovieModel(
    val voteCount: Int,
    val video: Boolean,
    val id: Int,
    val title: String,
    val popularity: Double,
    val voteAverage: Double,
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val genreIds: List<Int>,
    val originalTitle: String,
    val originalLanguage: String
)