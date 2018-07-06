package com.bkozajda.radioapp.presentation.discover.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel

class DiscoverMoviesViewModelFactory(private val discoverMoviesUseCase: DiscoverMoviesUseCase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverMoviesViewModel(discoverMoviesUseCase) as T
    }
}