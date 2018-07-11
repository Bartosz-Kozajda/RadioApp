package com.bkozajda.remote.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.remote.model.DetailedMovieModel

open class DetailedMovieEntityMapper : EntityMapper<DetailedMovieModel, DetailedMovieEntity> {
    override fun mapFromRemote(type: DetailedMovieModel): DetailedMovieEntity {
        val posterPath = "https://image.tmdb.org/t/p/w500${type.poster_path}"
        return DetailedMovieEntity(type.adult, type.budget, type.homepage, type.original_title, type.overview,
                posterPath, type.release_date, type.title, type.vote_average)
    }
}