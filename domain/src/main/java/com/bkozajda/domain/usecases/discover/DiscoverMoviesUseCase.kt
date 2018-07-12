package com.bkozajda.domain.usecases.discover

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.UseCase
import io.reactivex.Observable
import com.bkozajda.domain.executor.PostExecutionThread

class DiscoverMoviesUseCase(
    private val movieRepository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<List<Movie>, Int>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Int?): Observable<List<Movie>> {
        return movieRepository.discoverMovies(params ?: 1)
    }
}