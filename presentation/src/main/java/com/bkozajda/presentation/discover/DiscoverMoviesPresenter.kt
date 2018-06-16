package com.bkozajda.presentation.discover

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.presentation.mapper.MovieViewModelMapper
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DiscoverMoviesPresenter @Inject constructor(
    val view: DiscoverMoviesMvp.View,
    private val discoverMoviesUseCase: DiscoverMoviesUseCase,
    private val movieViewModelMapper: MovieViewModelMapper
) : DiscoverMoviesMvp.Presenter {
    override fun start() {
        collectMovies()
    }

    override fun stop() {
        discoverMoviesUseCase.dispose()
    }

    override fun collectMovies() {
        discoverMoviesUseCase.execute(DiscoverMoviesObserver())
    }

    inner class DiscoverMoviesObserver : DisposableSingleObserver<List<Movie>>() {
        override fun onError(e: Throwable) {
            System.out.println(e)
        }

        override fun onSuccess(movies: List<Movie>) {
            view.showMovies(movies.map { it -> movieViewModelMapper.mapToView(it) })
        }
    }
}