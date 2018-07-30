package com.bkozajda.radioapp.presentation.discover.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class DiscoverMoviesViewModel(
    private val discoverMoviesUseCase: DiscoverMoviesUseCase
) : ViewModel() {

    val list = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    val root = Job()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        /*val discoverDisposable = discoverMoviesUseCase
                .execute()
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ list.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        discoverMoviesUseCase.addDisposable(discoverDisposable)*/
        launch(CommonPool, parent = root) {
            try {
                isLoading.postValue(true)
                val result = discoverMoviesUseCase.exec(1)
                list.postValue(result)
            } catch (e: Exception) {
                errorHappened.postValue(true)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
        discoverMoviesUseCase.dispose()
    }
}