package com.bkozajda.radioapp.presentation.discover.di

import android.arch.lifecycle.ViewModelProviders
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesViewModel
import com.bkozajda.radioapp.presentation.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class DiscoverMoviesFragmentModule {
    @Provides
    fun provideDiscoverMoviesViewModelFactory(
        discoverMoviesUseCase: DiscoverMoviesUseCase
    ): DiscoverMoviesViewModelFactory = DiscoverMoviesViewModelFactory(discoverMoviesUseCase)

    @Provides
    fun provideDiscoverMoviesViewModel(
        activity: MainActivity,
        factory: DiscoverMoviesViewModelFactory
    ): DiscoverMoviesViewModel = ViewModelProviders.of(activity, factory).get(DiscoverMoviesViewModel::class.java)
}