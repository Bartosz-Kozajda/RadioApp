package com.bkozajda.remote.service

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import io.reactivex.Observable
import io.reactivex.Single

class MovieService(
    private val retrofitMovieService: RetrofitMovieService,
    private val movieEntityMapper: MovieEntityMapper,
    private val detailedMovieEntityMapper: DetailedMovieEntityMapper,
    private val apiKey: String
) : MovieRemote {
    override fun discoverMovies(page: Int): Single<List<MovieEntity>> {
        return retrofitMovieService.discoverMovies(apiKey, page).map {
            it.results.map { item ->
                movieEntityMapper.mapFromRemote(item)
            }
        }
    }

    override fun popularMovies(page: Int): Single<List<MovieEntity>> {
        return retrofitMovieService.popularMovies(apiKey, page).map {
            it.results.map { item ->
                movieEntityMapper.mapFromRemote(item)
            }
        }
    }

    override fun detailedMovie(movieId: Int): Single<DetailedMovieEntity> {
        return retrofitMovieService.detailedMovie(movieId, apiKey).map {
            detailedMovieEntityMapper.mapFromRemote(it)
        }
    }
}