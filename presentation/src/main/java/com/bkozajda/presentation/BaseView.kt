package com.bkozajda.presentation

interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter: T)
}