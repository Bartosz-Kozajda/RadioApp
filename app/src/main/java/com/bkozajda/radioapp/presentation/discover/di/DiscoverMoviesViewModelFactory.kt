package com.bkozajda.radioapp.presentation.discover.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.presentation.mapper.MovieViewModelMapper
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesViewModel

class DiscoverMoviesViewModelFactory(private val discoverMoviesUseCase: DiscoverMoviesUseCase,
                                     private val movieViewModelMapper: MovieViewModelMapper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverMoviesViewModel(discoverMoviesUseCase, movieViewModelMapper) as T
    }
}