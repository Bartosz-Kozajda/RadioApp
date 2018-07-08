package com.bkozajda.radioapp.presentation.discover.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel

class DiscoverMoviesViewModelFactory(private val discoverMoviesUseCase: DiscoverMoviesUseCase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverMoviesViewModel(discoverMoviesUseCase) as T
    }
}