package com.bkozajda.radioapp.presentation.discover

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.DiscoverMoviesUseCase
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DiscoverMoviesViewModel @Inject constructor(
    private val discoverMoviesUseCase: DiscoverMoviesUseCase
) : ViewModel() {

    val text = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        val discoverDisposable = discoverMoviesUseCase
                .execute()
                .subscribeWith(object : DisposableSingleObserver<List<Movie>>() {
                    override fun onStart() {
                        super.onStart()
                        isLoading.postValue(true)
                    }
                    override fun onSuccess(movies: List<Movie>) {
                        isLoading.postValue(false)
                        text.postValue(movies.toString())
                    }
                    override fun onError(e: Throwable) {
                        isLoading.postValue(false)
                        text.postValue(e.message)
                    }
                })
        discoverMoviesUseCase.addDisposable(discoverDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        discoverMoviesUseCase.dispose()
    }
}