package com.bkozajda.radioapp.presentation.discover

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DiscoverMoviesViewModel @Inject constructor(
        private val discoverMoviesUseCase: DiscoverMoviesUseCase
): ViewModel() {

    val text = MutableLiveData<String>()

    fun collectMovies() {
        discoverMoviesUseCase.execute(DiscoverMoviesObserver())
    }

    inner class DiscoverMoviesObserver : DisposableSingleObserver<List<Movie>>() {
        override fun onError(e: Throwable) {
            System.out.println(e)
        }

        override fun onSuccess(movies: List<Movie>) {
            text.postValue(movies.toString())
        }
    }
}