package com.bkozajda.data.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.domain.model.DetailedMovie

class DetailedMovieMapper : Mapper<DetailedMovieEntity, DetailedMovie> {

    override fun mapFromEntity(type: DetailedMovieEntity): DetailedMovie =
        DetailedMovie(
            type.adult, type.budget, type.homepage, type.original_title, type.overview,
            type.poster_path, type.release_date, type.title, type.vote_average
        )

    override fun mapToEntity(type: DetailedMovie): DetailedMovieEntity =
        DetailedMovieEntity(
            type.adult, type.budget, type.homepage, type.original_title, type.overview,
            type.poster_path, type.release_date, type.title, type.vote_average
        )
}