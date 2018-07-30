package com.bkozajda.data.repository

import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository

class MovieDataRepository(
    private val movieMapper: MovieMapper,
    private val detailedMovieMapper: DetailedMovieMapper,
    private val movieRemote: MovieRemote
) : MovieRepository {
    override suspend fun discoverMovies(page: Int): List<Movie> {
        return movieRemote.discoverMovies(page).map { item ->
            movieMapper.mapFromEntity(item)
        }
    }

    override suspend fun popularMovies(page: Int): List<Movie> {
        return movieRemote.popularMovies(page).map { item ->
            movieMapper.mapFromEntity(item)
        }
    }

    override suspend fun detailedMovie(movieId: Int): DetailedMovie {
        return detailedMovieMapper.mapFromEntity(movieRemote.detailedMovie(movieId))
    }
}
