package com.bkozajda.radioapp.presentation.movieDetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase

class MovieDetailViewModel constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {
    var title = MutableLiveData<String>()
    var posterPath = MutableLiveData<String>()

    fun fetchMovie(id: Int) {
        val movieDisposable = movieDetailUseCase
                .execute(id)
                .subscribe({
                    title.value = it.title
                    posterPath.value = it.poster_path
                }, { title.value = "error" }, {})
        movieDetailUseCase.addDisposable(movieDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        movieDetailUseCase.dispose()
    }
}