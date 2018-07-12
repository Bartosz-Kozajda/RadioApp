package com.bkozajda.radioapp.presentation.discover.di

import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverItemViewModel
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel
import com.bkozajda.radioapp.presentation.discover.view.DiscoverMoviesAdapter
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val DiscoverMoviesFragmentModule = module {
    viewModel { DiscoverMoviesViewModel(get()) }
    factory { DiscoverMoviesUseCase(get(), get()) }
    factory { DiscoverItemViewModel() }
    factory { DiscoverMoviesAdapter(get()) }
}