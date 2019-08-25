package com.bkozajda.radioapp.presentation.movieDetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.common.schedulers.RxSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class MovieDetailViewModel constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    private val schedulers: RxSchedulers
) : ViewModel() {

    var state: MovieDetailViewModelState = MovieDetailViewModelState.Empty()
    val movie = MutableLiveData<DetailedMovie>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    private val disposables = CompositeDisposable()

    fun onStart(id: Int) {
        when (state) {
            is MovieDetailViewModelState.Empty -> fetchMovie(id)
        }
    }

    private fun fetchMovie(id: Int) {
        disposables += movieDetailUseCase
            .execute(id)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.mainThread())
            .subscribeBy(
                onSuccess = { movie.value = it },
                onError = { errorHappened.value = true }
            )
    }

    public override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}