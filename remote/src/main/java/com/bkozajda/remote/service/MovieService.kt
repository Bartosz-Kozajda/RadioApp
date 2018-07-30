package com.bkozajda.remote.service

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper

class MovieService(
    private val retrofitMovieService: RetrofitMovieService,
    private val movieEntityMapper: MovieEntityMapper,
    private val detailedMovieEntityMapper: DetailedMovieEntityMapper,
    private val apiKey: String
) : MovieRemote {
    override suspend fun discoverMovies(page: Int): List<MovieEntity> {
        val result = retrofitMovieService.discoverMovies(apiKey, page)
        return result.await().results.map {
            item -> movieEntityMapper.mapFromRemote(item)
        }
    }

    override suspend fun popularMovies(page: Int): List<MovieEntity> {
        val result = retrofitMovieService.popularMovies(apiKey, page)
        return result.await().results.map {
            item -> movieEntityMapper.mapFromRemote(item)
        }
    }

    override suspend fun detailedMovie(movieId: Int): DetailedMovieEntity {
        val result = retrofitMovieService.detailedMovie(movieId, apiKey)
        return detailedMovieEntityMapper.mapFromRemote(result.await())
    }
}