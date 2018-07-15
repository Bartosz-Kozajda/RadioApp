package com.bkozajda.radioapp.presentation.popular.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.popular.PopularMoviesUseCase

class PopularMoviesViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {

    val list = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        val discoverDisposable = popularMoviesUseCase
                .execute()
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ list.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        popularMoviesUseCase.addDisposable(discoverDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        popularMoviesUseCase.dispose()
    }
}