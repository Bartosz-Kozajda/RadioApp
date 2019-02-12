package com.bkozajda.data.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.domain.model.DetailedMovie

open class DetailedMovieMapper : Mapper<DetailedMovieEntity, DetailedMovie> {
    override fun mapFromEntity(type: DetailedMovieEntity): DetailedMovie {
        val genres = type.genres.toString()
        return DetailedMovie(type.adult, type.budget.toString(), type.homepage, type.original_title, type.overview,
                type.poster_path, type.release_date, type.title, type.vote_average.toString(), genres, type.popularity.toString())
    }

    override fun mapToEntity(type: DetailedMovie): DetailedMovieEntity {
        return DetailedMovieEntity(type.adult, type.budget.toInt(), type.homepage, type.original_title, type.overview,
                type.poster_path, type.release_date, type.title, type.vote_average.toDouble(), type.genres.split(","), type.popularity.toDouble())
    }
}