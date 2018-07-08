package com.bkozajda.radioapp.presentation.main.di

import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.discover.view.DiscoverMoviesFragment
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesFragmentModule
import com.bkozajda.radioapp.presentation.movieDetail.di.MovieDetailFragmentModule
import com.bkozajda.radioapp.presentation.movieDetail.view.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [(DiscoverMoviesFragmentModule::class)])
    abstract fun discoverMoviesFragmentInjector(): DiscoverMoviesFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(MovieDetailFragmentModule::class)])
    abstract fun movieDetailFragmentInjector(): MovieDetailFragment
}
