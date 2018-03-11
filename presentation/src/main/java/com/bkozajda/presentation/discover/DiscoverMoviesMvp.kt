package com.bkozajda.presentation.discover

import com.bkozajda.presentation.BasePresenter
import com.bkozajda.presentation.BaseView

interface DiscoverMoviesMvp {
    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun showMovies()
    }

    interface Presenter : BasePresenter {
        fun collectMovies()
    }
}