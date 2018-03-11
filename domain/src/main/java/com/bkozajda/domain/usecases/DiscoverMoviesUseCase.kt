package com.bkozajda.domain.usecases

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.base.SingleUseCase
import io.reactivex.Single
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(val movieRepository: MovieRepository,
                                                threadExecutor: ThreadExecutor,
                                                postExecutionThread: PostExecutionThread) : SingleUseCase<List<Movie>, Void?>(threadExecutor, postExecutionThread)  {
    override fun buildUseCaseObservable(params: Void?): Single<List<Movie>> {
        // TODO: pass apiKey and page
        return movieRepository.discoverMovies("", 1)
    }
}