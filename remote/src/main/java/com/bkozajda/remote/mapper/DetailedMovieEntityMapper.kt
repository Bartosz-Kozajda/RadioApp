package com.bkozajda.remote.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.remote.model.DetailedMovieModel

internal const val POSTER_URL_PREFIX = "https://image.tmdb.org/t/p/w500"

class DetailedMovieEntityMapper : EntityMapper<DetailedMovieModel, DetailedMovieEntity> {

    override fun mapFromRemote(type: DetailedMovieModel): DetailedMovieEntity {
        // TODO: move url prefix
        val posterPath = POSTER_URL_PREFIX + type.poster_path
        return DetailedMovieEntity(
            type.adult, type.budget, type.homepage, type.original_title, type.overview,
            posterPath, type.release_date, type.title, type.vote_average
        )
    }
}