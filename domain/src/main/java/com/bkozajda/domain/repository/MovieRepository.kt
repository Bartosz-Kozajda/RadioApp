package com.bkozajda.domain.repository

import com.bkozajda.domain.model.Movie
import io.reactivex.Observable

interface MovieRepository {
    fun discoverMovies(page: Int): Observable<List<Movie>>
}