package com.bkozajda.radioapp.presentation.discover.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bkozajda.radioapp.presentation.discover.presentation.MovieItemViewModel

class MovieItemViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieItemViewModel() as T
    }
}