package com.bkozajda.radioapp.presentation.discover.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.common.schedulers.RxSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class DiscoverMoviesViewModel(
    private val discoverMoviesUseCase: DiscoverMoviesUseCase,
    private val schedulers: RxSchedulers
) : ViewModel() {

    val list = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorHappened = MutableLiveData<Boolean>()

    private val disposables = CompositeDisposable()

    init {
        collectMovies()
    }

    private fun collectMovies() {
        disposables += discoverMoviesUseCase
            .execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.mainThread())
            .subscribeBy(
                onSuccess = { list.value = it },
                onError = { errorHappened.value = true }
            )
    }

    public override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}