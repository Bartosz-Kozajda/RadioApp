package com.bkozajda.radioapp.presentation.popular.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.popular.PopularMoviesUseCase
import com.bkozajda.radioapp.common.schedulers.RxSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class PopularMoviesViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase,
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
        disposables += popularMoviesUseCase
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