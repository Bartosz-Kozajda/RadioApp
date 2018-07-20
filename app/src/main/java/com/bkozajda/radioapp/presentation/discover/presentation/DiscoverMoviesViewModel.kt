package com.bkozajda.radioapp.presentation.discover.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase

class DiscoverMoviesViewModel(
    private val discoverMoviesUseCase: DiscoverMoviesUseCase
) : ViewModel() {

    val list = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        val discoverDisposable = discoverMoviesUseCase
                .execute()
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ list.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        discoverMoviesUseCase.addDisposable(discoverDisposable)
    }

    public override fun onCleared() {
        super.onCleared()
        discoverMoviesUseCase.dispose()
    }
}