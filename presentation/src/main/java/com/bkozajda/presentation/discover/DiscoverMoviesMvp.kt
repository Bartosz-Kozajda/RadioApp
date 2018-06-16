package com.bkozajda.presentation.discover

import com.bkozajda.presentation.BasePresenter
import com.bkozajda.presentation.BaseView
import com.bkozajda.presentation.model.MovieViewModel

interface DiscoverMoviesMvp {
    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun showMovies(movies: List<MovieViewModel>)
    }

    interface Presenter : BasePresenter {
        fun collectMovies()
    }
}