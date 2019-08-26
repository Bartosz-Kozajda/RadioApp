package com.bkozajda.radioapp.common.extensions

import androidx.lifecycle.MutableLiveData
import com.bkozajda.radioapp.common.state.ViewModelState
import com.bkozajda.radioapp.common.state.ViewModelState.Error
import com.bkozajda.radioapp.common.state.ViewModelState.Loading
import com.bkozajda.radioapp.common.state.ViewModelState.Loaded
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

fun <T : Any> Single<T>.subscribeWithState(
    state: MutableLiveData<ViewModelState>,
    data: MutableLiveData<T>
): Disposable = doOnSubscribe { state.value = Loading }
    .subscribeBy(
        onSuccess = {
            state.value = Loaded(it)
            data.value = it
        },
        onError = {
            state.value = Error
        }
    )
