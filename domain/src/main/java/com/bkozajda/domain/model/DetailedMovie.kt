package com.bkozajda.domain.model

data class DetailedMovie(
    val adult: Boolean,
    val budget: Int,
    val homepage: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
)