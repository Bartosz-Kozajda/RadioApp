package com.bkozajda.domain.usecases.movieDetail

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.repository.MovieRepository
import io.reactivex.Single

class MovieDetailUseCase(
    private val movieRepository: MovieRepository
) {
    fun execute(movieId: Int): Single<DetailedMovie> =
        movieRepository.detailedMovie(movieId)
}