package com.bkozajda.data.repository

import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.Single

class MovieDataRepository(
    private val movieMapper: MovieMapper,
    private val detailedMovieMapper: DetailedMovieMapper,
    private val movieRemote: MovieRemote
) : MovieRepository {
    override fun discoverMovies(page: Int): Single<List<Movie>> {
        return movieRemote.discoverMovies(page)
            .map {
                it.map { item ->
                    movieMapper.mapFromEntity(item)
                }
            }
    }

    override fun popularMovies(page: Int): Single<List<Movie>> {
        return movieRemote.popularMovies(page)
            .map {
                it.map { item ->
                    movieMapper.mapFromEntity(item)
                }
            }
    }

    override fun detailedMovie(movieId: Int): Single<DetailedMovie> {
        return movieRemote.detailedMovie(movieId)
            .map { detailedMovieMapper.mapFromEntity(it) }
    }
}
