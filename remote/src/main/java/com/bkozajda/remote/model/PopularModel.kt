package com.bkozajda.remote.model

data class PopularModel(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieModel>
)