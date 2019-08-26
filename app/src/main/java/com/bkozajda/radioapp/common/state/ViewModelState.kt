package com.bkozajda.radioapp.common.state

sealed class ViewModelState {
    object Loading : ViewModelState()
    data class Loaded<T>(val data: T) : ViewModelState()
    object Error : ViewModelState()

    fun isLoading(): Boolean =
        this is Loading

    fun isLoaded(): Boolean =
        this is Loaded<*>

    fun isError(): Boolean =
        this is Error

    fun <T> data(): T =
        (this as Loaded<T>).data
}