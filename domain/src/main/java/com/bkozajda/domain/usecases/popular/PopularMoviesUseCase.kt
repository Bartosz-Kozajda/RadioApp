package com.bkozajda.domain.usecases.popular

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import io.reactivex.Single

class PopularMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    fun execute(page: Int = 1): Single<List<Movie>> =
        movieRepository.popularMovies(page)
}