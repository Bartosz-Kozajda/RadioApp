package com.bkozajda.radioapp.presentation.movieDetail.presentation

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.common.BaseViewModelTest
import com.bkozajda.radioapp.common.TestRxSchedulers
import com.bkozajda.radioapp.common.state.ViewModelState.Error
import com.bkozajda.radioapp.common.state.ViewModelState.Loaded
import com.bkozajda.radioapp.common.state.ViewModelState.Loading
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieDetailViewModelTest : BaseViewModelTest() {

    val movieDetailUseCase: MovieDetailUseCase = mock {
        on { execute(any()) } doReturn Single.never()
    }

    val tested: MovieDetailViewModel by lazy {
        MovieDetailViewModel(movieDetailUseCase, TestRxSchedulers())
    }

    @Test
    fun `should set state to loading when starts to fetch data`() {
        tested.onFirstCreate()

        tested.state.value shouldEqual Loading
    }

    @Test
    fun `should set state to loaded when data is fetched`() {
        val data = mock<DetailedMovie>()
        whenever(movieDetailUseCase.execute(tested.movieId)).thenReturn(Single.just(data))

        tested.onFirstCreate()

        tested.state.value shouldEqual Loaded(data)
        tested.data.value shouldEqual data
    }

    @Test
    fun `should set state to error when error occurred`() {
        whenever(movieDetailUseCase.execute(tested.movieId)).thenReturn(Single.error(Throwable()))

        tested.onFirstCreate()

        tested.state.value shouldEqual Error
    }
}