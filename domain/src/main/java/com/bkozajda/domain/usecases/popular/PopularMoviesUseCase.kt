package com.bkozajda.domain.usecases.popular

import com.bkozajda.domain.executor.PostExecutionThread
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.UseCase
import io.reactivex.Observable

class PopularMoviesUseCase(
    private val movieRepository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<List<Movie>, Int>(postExecutionThread) {
    suspend fun exec(params: Int?): List<Movie> {
        return movieRepository.popularMovies(params ?: 2)
    }
    override fun buildUseCaseObservable(params: Int?): Observable<List<Movie>> {
        return Observable.empty()
    }
}