package com.bkozajda.remote.service

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import io.reactivex.Single

// TODO: move api key to interceptor
class MovieService(
    private val retrofitMovieService: RetrofitMovieService,
    private val movieEntityMapper: MovieEntityMapper,
    private val detailedMovieEntityMapper: DetailedMovieEntityMapper,
    private val apiKey: String
) : MovieRemote {

    override fun discoverMovies(page: Int): Single<List<MovieEntity>> =
        retrofitMovieService.discoverMovies(apiKey, page)
            .map {
                it.results.map { item ->
                    movieEntityMapper.mapFromRemote(item)
                }
            }

    override fun popularMovies(page: Int): Single<List<MovieEntity>> =
        retrofitMovieService.popularMovies(apiKey, page)
            .map {
                it.results.map { item ->
                    movieEntityMapper.mapFromRemote(item)
                }
            }

    override fun detailedMovie(movieId: Int): Single<DetailedMovieEntity> =
        retrofitMovieService.detailedMovie(movieId, apiKey)
            .map { detailedMovieEntityMapper.mapFromRemote(it) }
}