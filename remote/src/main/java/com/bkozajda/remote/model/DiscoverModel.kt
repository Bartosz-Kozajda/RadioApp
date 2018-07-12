package com.bkozajda.remote.model

data class DiscoverModel(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val movies: List<MovieModel>
)