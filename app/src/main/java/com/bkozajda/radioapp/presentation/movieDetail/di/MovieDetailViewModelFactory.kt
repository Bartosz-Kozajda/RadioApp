package com.bkozajda.radioapp.presentation.movieDetail.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel

class MovieDetailViewModelFactory(private val movieDetailUseCase: MovieDetailUseCase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(movieDetailUseCase) as T
    }
}