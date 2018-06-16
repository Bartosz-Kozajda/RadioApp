package com.bkozajda.radioapp.main.di

import com.bkozajda.presentation.discover.DiscoverMoviesMvp
import com.bkozajda.presentation.discover.DiscoverMoviesPresenter
import com.bkozajda.presentation.mapper.MovieViewModelMapper
import com.bkozajda.radioapp.di.scopes.PerActivity
import com.bkozajda.radioapp.main.MainActivity
import dagger.Module
import dagger.Provides
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase

@Module
open class MainActivityModule {

    @Provides
    @PerActivity
    fun provideDiscoverMoviesView(mainActivity: MainActivity): DiscoverMoviesMvp.View = mainActivity

    @Provides
    @PerActivity
    fun provideDiscoverMoviesPresenter(
        view: DiscoverMoviesMvp.View,
        discoverMoviesUseCase: DiscoverMoviesUseCase,
        mapper: MovieViewModelMapper
    ): DiscoverMoviesMvp.Presenter = DiscoverMoviesPresenter(view, discoverMoviesUseCase, mapper)
}
