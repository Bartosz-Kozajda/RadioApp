package com.bkozajda.radioapp.presentation.discover.di

import androidx.lifecycle.ViewModelProviders
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel
import com.bkozajda.radioapp.presentation.discover.view.DiscoverMoviesAdapter
import com.bkozajda.radioapp.presentation.main.MainActivity
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

@Module
open class DiscoverMoviesFragmentModule {
    @Provides
    @PerFragment
    fun provideDiscoverMoviesViewModelFactory(
        discoverMoviesUseCase: DiscoverMoviesUseCase
    ): DiscoverMoviesViewModelFactory = DiscoverMoviesViewModelFactory(discoverMoviesUseCase)

    @Provides
    @PerFragment
    fun provideDiscoverMoviesViewModel(
        activity: MainActivity,
        factory: DiscoverMoviesViewModelFactory
    ): DiscoverMoviesViewModel = ViewModelProviders.of(activity, factory).get(DiscoverMoviesViewModel::class.java)

    @Provides
    @PerFragment
    fun provideDiscoverMoviesUseCase(
        repository: MovieRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
    ): DiscoverMoviesUseCase = DiscoverMoviesUseCase(repository, threadExecutor, postExecutionThread)

    @Provides
    @PerFragment
    fun provideDiscoverMoviesAdapter(
    ): DiscoverMoviesAdapter = DiscoverMoviesAdapter()
}