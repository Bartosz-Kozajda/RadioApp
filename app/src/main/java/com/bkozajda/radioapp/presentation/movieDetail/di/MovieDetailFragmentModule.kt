package com.bkozajda.radioapp.presentation.movieDetail.di

import android.arch.lifecycle.ViewModelProviders
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.main.MainActivity
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

@Module
open class MovieDetailFragmentModule {
    @Provides
    @PerFragment
    fun provideDiscoverMoviesViewModelFactory(movieDetailUseCase: MovieDetailUseCase): MovieDetailViewModelFactory =
            MovieDetailViewModelFactory(movieDetailUseCase)

    @Provides
    @PerFragment
    fun provideMovieDetailViewModel(
        activity: MainActivity,
        factory: MovieDetailViewModelFactory
    ): MovieDetailViewModel = ViewModelProviders.of(activity, factory).get(MovieDetailViewModel::class.java)

    @Provides
    @PerFragment
    fun provideMovieDetailUseCase(
        repository: MovieRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
    ): MovieDetailUseCase = MovieDetailUseCase(repository, threadExecutor, postExecutionThread)
}