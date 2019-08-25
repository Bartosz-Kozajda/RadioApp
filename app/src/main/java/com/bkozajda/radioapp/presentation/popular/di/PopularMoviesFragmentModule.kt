package com.bkozajda.radioapp.presentation.popular.di

import com.bkozajda.domain.usecases.popular.PopularMoviesUseCase
import com.bkozajda.radioapp.presentation.popular.presentation.PopularItemViewModel
import com.bkozajda.radioapp.presentation.popular.presentation.PopularMoviesViewModel
import com.bkozajda.radioapp.presentation.popular.view.PopularMoviesAdapter
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val PopularMoviesFragmentModule = module {
    viewModel { PopularMoviesViewModel(get(), get()) }
    factory { PopularMoviesUseCase(get()) }
    factory { PopularItemViewModel() }
    factory { PopularMoviesAdapter(get()) }
}