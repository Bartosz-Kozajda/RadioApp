package com.bkozajda.radioapp.presentation.movieDetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase

class MovieDetailViewModel constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {
    var state: MovieDetailViewModelState = MovieDetailViewModelState.Empty()
    val movie = MutableLiveData<DetailedMovie>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    fun onStart(id: Int) {
        when (state) {
            is MovieDetailViewModelState.Empty -> fetchMovie(id)
        }
    }

    private fun fetchMovie(id: Int) {
        val movieDisposable = movieDetailUseCase
                .execute(id)
                .doOnSubscribe { isLoading.value = true }
                .doFinally {
                    isLoading.value = false
                    state = MovieDetailViewModelState.Loaded()
                }
                .subscribe({ movie.value = it }, { errorHappened.value = true }, { isLoading.value = false })
        movieDetailUseCase.addDisposable(movieDisposable)
    }

    public override fun onCleared() {
        super.onCleared()
        movieDetailUseCase.dispose()
    }
}