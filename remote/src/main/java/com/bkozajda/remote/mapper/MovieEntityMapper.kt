package com.bkozajda.remote.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.remote.model.MovieModel

class MovieEntityMapper : EntityMapper<MovieModel, MovieEntity> {

    override fun mapFromRemote(type: MovieModel): MovieEntity {
        val posterPath = POSTER_URL_PREFIX + type.poster_path
        return MovieEntity(type.id, type.title, type.vote_average, posterPath)
    }
}