package com.bkozajda.data.repository

import com.bkozajda.data.model.MovieEntity
import io.reactivex.Observable

interface MovieRemote {
    fun discoverMovies(page: Int): Observable<List<MovieEntity>>
}