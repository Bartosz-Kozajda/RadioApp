package com.bkozajda.domain.usecases.base

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

abstract class UseCase<T, in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    fun execute(params: Params? = null): Observable<T> {
        return buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler) as Observable<T>
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}