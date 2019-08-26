package com.bkozajda.radioapp.presentation.movieDetail.presentation

import androidx.lifecycle.MutableLiveData
import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.common.extensions.subscribeWithState
import com.bkozajda.radioapp.common.schedulers.RxSchedulers
import com.bkozajda.radioapp.common.state.ViewModelState
import com.bkozajda.radioapp.common.viewmodels.LifecycleViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class MovieDetailViewModel constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    private val schedulers: RxSchedulers
) : LifecycleViewModel() {

    // TODO: provide movie id via constructor
    var movieId: Int = 0

    val state = MutableLiveData<ViewModelState>()
    val data = MutableLiveData<DetailedMovie>()

    private val disposables = CompositeDisposable()

    override fun onFirstCreate() {
        super.onFirstCreate()
        fetchMovie(movieId)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private fun fetchMovie(id: Int) {
        disposables += movieDetailUseCase
            .execute(id)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.mainThread())
            .subscribeWithState(state, data)
    }
}