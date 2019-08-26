package com.bkozajda.radioapp.common

import com.bkozajda.radioapp.common.schedulers.RxSchedulers

class TestRxSchedulers : RxSchedulers() {
    override fun mainThread() = trampoline()
    override fun io() = trampoline()
    override fun computation() = trampoline()
}