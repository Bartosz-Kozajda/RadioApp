package com.bkozajda.data.repository

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import io.reactivex.Single

interface MovieRemote {
    fun discoverMovies(page: Int): Single<List<MovieEntity>>
    fun popularMovies(page: Int): Single<List<MovieEntity>>
    fun detailedMovie(movieId: Int): Single<DetailedMovieEntity>
}