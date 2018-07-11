package com.bkozajda.radioapp.presentation.movieDetail.di

import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val MovieDetailFragmentModule = module {
    viewModel { MovieDetailViewModel(get()) }
    factory { MovieDetailUseCase(get(), get(), get()) }
}