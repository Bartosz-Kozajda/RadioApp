package com.bkozajda.radioapp.presentation.main.di

import android.arch.lifecycle.ViewModelProviders
import com.bkozajda.presentation.mapper.MovieViewModelMapper
import com.bkozajda.radioapp.di.scopes.PerActivity
import com.bkozajda.radioapp.presentation.main.MainActivity
import dagger.Module
import dagger.Provides
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesViewModel
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesViewModelFactory

@Module
open class MainActivityModule {
    @Provides
    @PerActivity
    fun provideDiscoverMoviesViewModelFactory(
        discoverMoviesUseCase: DiscoverMoviesUseCase,
        mapper: MovieViewModelMapper
    ): DiscoverMoviesViewModelFactory = DiscoverMoviesViewModelFactory(discoverMoviesUseCase, mapper)

    @Provides
    @PerActivity
    fun provideDiscoverMoviesViewModel(
            activity: MainActivity,
            factory: DiscoverMoviesViewModelFactory
    ): DiscoverMoviesViewModel = ViewModelProviders.of(activity, factory).get(DiscoverMoviesViewModel::class.java)
}
