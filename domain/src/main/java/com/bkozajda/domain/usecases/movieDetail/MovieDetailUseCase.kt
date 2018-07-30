package com.bkozajda.domain.usecases.movieDetail

import com.bkozajda.domain.executor.PostExecutionThread
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.UseCase
import io.reactivex.Observable

class MovieDetailUseCase(
    private val movieRepository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<DetailedMovie, Int>(postExecutionThread) {
    suspend fun exec(params: Int?): DetailedMovie {
        return movieRepository.detailedMovie(params!!)
    }
    override fun buildUseCaseObservable(params: Int?): Observable<DetailedMovie> {
        return Observable.empty()
    }
}