package com.bkozajda.radioapp.presentation.popular.presentation

import androidx.lifecycle.MutableLiveData
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.popular.PopularMoviesUseCase
import com.bkozajda.radioapp.common.extensions.subscribeWithState
import com.bkozajda.radioapp.common.schedulers.RxSchedulers
import com.bkozajda.radioapp.common.state.ViewModelState
import com.bkozajda.radioapp.common.viewmodels.LifecycleViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class PopularMoviesViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase,
    private val schedulers: RxSchedulers
) : LifecycleViewModel() {

    val state = MutableLiveData<ViewModelState>()
    val data = MutableLiveData<List<Movie>>()

    private val disposables = CompositeDisposable()

    override fun onFirstCreate() {
        super.onFirstCreate()
        collectMovies()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private fun collectMovies() {
        disposables += popularMoviesUseCase
            .execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.mainThread())
            .subscribeWithState(state, data)
    }
}