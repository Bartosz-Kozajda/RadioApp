package com.bkozajda.remote.model

data class MovieModel(
    val vote_count: Int,
    val video: Boolean,
    val id: Int,
    val title: String,
    val popularity: Double,
    val vote_average: Double,
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val original_title: String,
    val original_language: String,
    val backdrop_path: String?
)