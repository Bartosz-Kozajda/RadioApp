package com.bkozajda.data.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.domain.model.Movie
import javax.inject.Inject

open class MovieMapper @Inject constructor(): Mapper<MovieEntity, Movie> {
    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(type.id, type.title, type.voteAverage, type.posterPath)
    }

    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(type.id, type.title, type.voteAverage, type.posterPath)
    }
}