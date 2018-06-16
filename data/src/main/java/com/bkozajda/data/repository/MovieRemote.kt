package com.bkozajda.data.repository

import com.bkozajda.data.model.MovieEntity
import io.reactivex.Single

interface MovieRemote {
    fun discoverMovies(page: Int): Single<List<MovieEntity>>
}