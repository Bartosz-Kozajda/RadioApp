package com.bkozajda.domain.usecases.discover

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.UseCase
import io.reactivex.Observable
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

class DiscoverMoviesUseCase(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<List<Movie>, Int>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Int?): Observable<List<Movie>> {
        return movieRepository.discoverMovies(params ?: 1)
    }
}