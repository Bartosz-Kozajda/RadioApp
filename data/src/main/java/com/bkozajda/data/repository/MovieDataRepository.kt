package com.bkozajda.data.repository

import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieDataRepository(
    private val movieMapper: MovieMapper,
    private val detailedMovieMapper: DetailedMovieMapper,
    private val movieRemote: MovieRemote
) : MovieRepository {
    override fun discoverMovies(page: Int): Observable<List<Movie>> {
        return movieRemote.discoverMovies(page)
                .map {
                    it.map { item ->
                        movieMapper.mapFromEntity(item)
                    }
                }
    }

    override fun popularMovies(page: Int): Observable<List<Movie>> {
        return movieRemote.popularMovies(page)
                .map {
                    it.map { item ->
                        movieMapper.mapFromEntity(item)
                    }
                }
    }

    override fun detailedMovie(movieId: Int): Observable<DetailedMovie> {
        return movieRemote.detailedMovie(movieId)
                .map { it ->
                    detailedMovieMapper.mapFromEntity(it)
                }
    }
}
