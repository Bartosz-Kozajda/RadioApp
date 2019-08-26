package com.bkozajda.domain.repository

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.model.Movie
import io.reactivex.Single

interface MovieRepository {
    fun discoverMovies(page: Int): Single<List<Movie>>
    fun popularMovies(page: Int): Single<List<Movie>>
    fun detailedMovie(movieId: Int): Single<DetailedMovie>
}