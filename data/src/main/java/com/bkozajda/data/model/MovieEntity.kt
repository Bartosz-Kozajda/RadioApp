package com.bkozajda.data.model

data class MovieEntity(
        val id: Int,
        val title: String,
        val voteAverage: Double,
        val posterPath: String)