package com.bkozajda.domain.repository

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.model.Movie

interface MovieRepository {
    suspend fun discoverMovies(page: Int): List<Movie>
    suspend fun popularMovies(page: Int): List<Movie>
    suspend fun detailedMovie(movieId: Int): DetailedMovie
}