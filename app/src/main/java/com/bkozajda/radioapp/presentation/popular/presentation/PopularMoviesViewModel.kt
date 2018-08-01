package com.bkozajda.radioapp.presentation.popular.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.popular.PopularMoviesUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class PopularMoviesViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {

    val list = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    val root = Job()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        /*val discoverDisposable = popularMoviesUseCase
                .execute()
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ list.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        popularMoviesUseCase.addDisposable(discoverDisposable)*/
        launch(CommonPool, parent = root) {
            try {
                isLoading.postValue(true)
                val result = popularMoviesUseCase.exec(1)
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
        popularMoviesUseCase.dispose()
    }
}