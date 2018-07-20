package com.bkozajda.radioapp.presentation.discover.presentation

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.usecases.discover.DiscoverMoviesUseCase
import com.bkozajda.radioapp.common.BaseViewModelTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.subjects.PublishSubject
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class DiscoverMoviesViewModelTest : BaseViewModelTest() {

    val discoverMoviesUseCase: DiscoverMoviesUseCase = mock()
    val result = PublishSubject.create<List<Movie>>()

    @Before
    override fun setUp() {
        super.setUp()
        whenever(discoverMoviesUseCase.execute()).thenReturn(result)
    }

    @Test
    fun `should show progress bar when starts to fetch data`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)

        testSubject.isLoading.value shouldEqual true
    }

    @Test
    fun `should hide progress bar when data is fetched`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)

        result.onComplete()

        testSubject.isLoading.value shouldEqual false
    }

    @Test
    fun `should hide progress bar when error occurs`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)

        result.onError(Throwable())

        testSubject.isLoading.value shouldEqual false
    }

    @Test
    fun `should show error message when error occurs`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)

        result.onError(Throwable())

        testSubject.errorHappened.value shouldEqual true
    }

    @Test
    fun `should load list when data is fetched`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)
        val data = givenResultData()
        result.onNext(data)

        testSubject.list.value shouldEqual data
    }

    @Test
    fun `should call dispose when viewModel is cleared`() {
        val testSubject = DiscoverMoviesViewModel(discoverMoviesUseCase)

        testSubject.onCleared()

        verify(discoverMoviesUseCase).dispose()
    }

    private fun givenResultData(): List<Movie> {
        val movie: Movie = mock()
        return listOf(movie)
    }
}