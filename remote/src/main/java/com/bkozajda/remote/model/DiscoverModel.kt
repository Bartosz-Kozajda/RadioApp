package com.bkozajda.remote.model

data class DiscoverModel(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieModel>
)