package com.bkozajda.radioapp

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import com.bkozajda.domain.executor.PostExecutionThread

class UiThread : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}