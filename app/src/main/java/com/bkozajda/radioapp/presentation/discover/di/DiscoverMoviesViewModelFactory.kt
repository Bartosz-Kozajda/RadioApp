package com.bkozajda.radioapp.presentation.discover.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesViewModel

class DiscoverMoviesViewModelFactory(private val discoverMoviesUseCase: DiscoverMoviesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverMoviesViewModel(discoverMoviesUseCase) as T
    }
}