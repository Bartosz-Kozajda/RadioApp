package com.bkozajda.remote.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.remote.model.MovieModel

open class MovieEntityMapper : EntityMapper<MovieModel, MovieEntity> {
    override fun mapFromRemote(type: MovieModel): MovieEntity {
        val posterPath = "https://image.tmdb.org/t/p/w500${type.posterPath}"
        return MovieEntity(type.id, type.title, type.voteAverage, posterPath)
    }
}