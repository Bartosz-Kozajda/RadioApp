package com.bkozajda.domain.usecases.movieDetail

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.UseCase
import io.reactivex.Observable
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

class MovieDetailUseCase(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<DetailedMovie, Int>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Int?): Observable<DetailedMovie> {
        return movieRepository.detailedMovie(params!!)
    }
}