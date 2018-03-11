package com.bkozajda.radioapp.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bkozajda.presentation.discover.DiscoverMoviesMvp
import com.bkozajda.presentation.mapper.MovieViewModelMapper
import com.bkozajda.radioapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DiscoverMoviesMvp.View {

    @Inject
    lateinit var discoverMoviesPresenter: DiscoverMoviesMvp.Presenter

    @Inject
    lateinit var mapper: MovieViewModelMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        discoverMoviesPresenter.start()
    }

    override fun setPresenter(presenter: DiscoverMoviesMvp.Presenter) {
        discoverMoviesPresenter = presenter
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
