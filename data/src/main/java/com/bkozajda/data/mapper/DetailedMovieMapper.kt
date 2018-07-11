package com.bkozajda.data.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.domain.model.DetailedMovie

open class DetailedMovieMapper : Mapper<DetailedMovieEntity, DetailedMovie> {
    override fun mapFromEntity(type: DetailedMovieEntity): DetailedMovie {
        return DetailedMovie(type.adult, type.budget, type.homepage, type.original_title, type.overview,
                type.poster_path, type.release_date, type.title, type.vote_average)
    }

    override fun mapToEntity(type: DetailedMovie): DetailedMovieEntity {
        return DetailedMovieEntity(type.adult, type.budget, type.homepage, type.original_title, type.overview,
                type.poster_path, type.release_date, type.title, type.vote_average)
    }
}