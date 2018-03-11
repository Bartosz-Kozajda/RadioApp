package com.bkozajda.data.repository

import com.bkozajda.data.model.MovieEntity
import io.reactivex.Single

interface MovieRemote {
    fun discoverMovies(apiKey: String, page: Int): Single<List<MovieEntity>>
}