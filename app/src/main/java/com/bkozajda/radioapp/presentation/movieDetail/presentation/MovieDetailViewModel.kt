package com.bkozajda.radioapp.presentation.movieDetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class MovieDetailViewModel constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {
    var state: MovieDetailViewModelState = MovieDetailViewModelState.Empty()
    val movie = MutableLiveData<DetailedMovie>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    val root = Job()

    fun onStart(id: Int) {
        when (state) {
            is MovieDetailViewModelState.Empty -> fetchMovie(id)
        }
    }

    private fun fetchMovie(id: Int) {
        /*val movieDisposable = movieDetailUseCase
                .execute(id)
                .doOnSubscribe { isLoading.value = true }
                .doFinally {
                    isLoading.value = false
                    state = MovieDetailViewModelState.Loaded()
                }
                .subscribe({ movie.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        movieDetailUseCase.addDisposable(movieDisposable)*/

        launch(CommonPool, parent = root) {
            try {
                isLoading.postValue(true)
                val result = movieDetailUseCase.exec(1)
                movie.postValue(result)
            } catch (e: Exception) {
                errorHappened.postValue(true)
            } finally {
                isLoading.postValue(false)
                state = MovieDetailViewModelState.Loaded()
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
        movieDetailUseCase.dispose()
    }
}