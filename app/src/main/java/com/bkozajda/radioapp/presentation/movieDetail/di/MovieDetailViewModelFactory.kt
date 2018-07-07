package com.bkozajda.radioapp.presentation.movieDetail.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel

class MovieDetailViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel() as T
    }
}