package com.bkozajda.radioapp.presentation.discover.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import javax.inject.Inject

class DiscoverMoviesViewModel @Inject constructor(
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

    override fun onCleared() {
        super.onCleared()
        discoverMoviesUseCase.dispose()
    }
}