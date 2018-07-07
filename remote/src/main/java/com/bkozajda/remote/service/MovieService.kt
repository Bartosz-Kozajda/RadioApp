package com.bkozajda.remote.service

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import io.reactivex.Observable
import javax.inject.Inject

class MovieService @Inject constructor(
    private val retrofitMovieService: RetrofitMovieService,
    private val movieEntityMapper: MovieEntityMapper,
    private val detailedMovieEntityMapper: DetailedMovieEntityMapper,
    private val apiKey: String
) : MovieRemote {
    override fun discoverMovies(page: Int): Observable<List<MovieEntity>> {
        return retrofitMovieService.discoverMovies(apiKey, page).map {
            it.movies.map {
                item -> movieEntityMapper.mapFromRemote(item)
            }
        }
    }

    override fun detailedMovie(movieId: Int): Observable<DetailedMovieEntity> {
        return retrofitMovieService.detailedMovie(movieId, apiKey).map {
            it -> detailedMovieEntityMapper.mapFromRemote(it)
        }
    }
}