package com.bkozajda.radioapp.presentation.discover.presentation

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.common.BaseViewModelTest
import com.bkozajda.radioapp.common.TestRxSchedulers
import com.bkozajda.radioapp.common.state.ViewModelState.Error
import com.bkozajda.radioapp.common.state.ViewModelState.Loaded
import com.bkozajda.radioapp.common.state.ViewModelState.Loading
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.amshove.kluent.shouldEqual
import org.junit.Test

class DiscoverMoviesViewModelTest : BaseViewModelTest() {

    val discoverMoviesUseCase: DiscoverMoviesUseCase = mock {
        on { execute() } doReturn Single.never()
    }

    val tested: DiscoverMoviesViewModel by lazy {
        DiscoverMoviesViewModel(discoverMoviesUseCase, TestRxSchedulers())
    }

    @Test
    fun `should set state to loading when starts to fetch data`() {
        tested.onFirstCreate()

        tested.state.value shouldEqual Loading
    }

    @Test
    fun `should set state to loaded when data is fetched`() {
        val data = givenResultData()
        whenever(discoverMoviesUseCase.execute()).thenReturn(Single.just(data))

        tested.onFirstCreate()

        tested.state.value shouldEqual Loaded(data)
        tested.data.value shouldEqual data
    }

    @Test
    fun `should set state to error when error occurred`() {
        whenever(discoverMoviesUseCase.execute()).thenReturn(Single.error(Throwable()))

        tested.onFirstCreate()

        tested.state.value shouldEqual Error
    }

    private fun givenResultData(): List<Movie> {
        val movie: Movie = mock()
        return listOf(movie)
    }
}