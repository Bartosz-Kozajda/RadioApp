package com.bkozajda.radioapp.presentation.movieDetail.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
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