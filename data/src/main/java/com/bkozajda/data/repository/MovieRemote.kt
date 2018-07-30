package com.bkozajda.data.repository

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity

interface MovieRemote {
    suspend fun discoverMovies(page: Int): List<MovieEntity>
    suspend fun popularMovies(page: Int): List<MovieEntity>
    suspend fun detailedMovie(movieId: Int): DetailedMovieEntity
}