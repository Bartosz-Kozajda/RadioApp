package com.bkozajda.radioapp.presentation.movieDetail.di

import android.arch.lifecycle.ViewModelProviders
import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.main.MainActivity
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import dagger.Module
import dagger.Provides

@Module
open class MovieDetailFragmentModule {
    @Provides
    @PerFragment
    fun provideDiscoverMoviesViewModelFactory(): MovieDetailViewModelFactory = MovieDetailViewModelFactory()

    @Provides
    @PerFragment
    fun provideDiscoverMoviesViewModel(
        activity: MainActivity,
        factory: MovieDetailViewModelFactory
    ): MovieDetailViewModel = ViewModelProviders.of(activity, factory).get(MovieDetailViewModel::class.java)
}