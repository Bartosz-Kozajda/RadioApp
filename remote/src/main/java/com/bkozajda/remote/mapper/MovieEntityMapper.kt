package com.bkozajda.remote.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.remote.model.MovieModel

open class MovieEntityMapper : EntityMapper<MovieModel, MovieEntity> {
    override fun mapFromRemote(type: MovieModel): MovieEntity {
        return MovieEntity(type.id, type.title, type.voteAverage, type.posterPath)
    }
}