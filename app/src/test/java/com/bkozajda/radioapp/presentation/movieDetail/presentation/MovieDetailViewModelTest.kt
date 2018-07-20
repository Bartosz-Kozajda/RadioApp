package com.bkozajda.radioapp.presentation.movieDetail.presentation

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.usecases.movieDetail.MovieDetailUseCase
import com.bkozajda.radioapp.common.BaseViewModelTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.subjects.PublishSubject
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class MovieDetailViewModelTest : BaseViewModelTest() {

    val movieDetailUseCase: MovieDetailUseCase = mock()
    val result = PublishSubject.create<DetailedMovie>()

    val testSubject = MovieDetailViewModel(movieDetailUseCase)

    @Before
    override fun setUp() {
        super.setUp()
        whenever(movieDetailUseCase.execute(any())).thenReturn(result)
    }

    @Test
    fun `should show progress bar when starts to fetch data`() {
        testSubject.onStart(1)

        testSubject.isLoading.value shouldEqual true
    }

    @Test
    fun `should hide progress bar when data is fetched`() {
        testSubject.onStart(1)

        result.onComplete()

        testSubject.isLoading.value shouldEqual false
    }

    @Test
    fun `should hide progress bar when error occurs`() {
        testSubject.onStart(1)

        result.onError(Throwable())

        testSubject.isLoading.value shouldEqual false
    }

    @Test
    fun `should show error message when error occurs`() {
        testSubject.onStart(1)

        result.onError(Throwable())

        testSubject.errorHappened.value shouldEqual true
    }

    @Test
    fun `should load movie when data is fetched`() {
        val data = mock<DetailedMovie>()
        testSubject.onStart(1)

        result.onNext(data)

        testSubject.movie.value shouldEqual data
    }

    @Test
    fun `should set state to loaded when data is fetched`() {
        testSubject.onStart(1)

        result.onComplete()

        testSubject.state shouldBeInstanceOf MovieDetailViewModelState.Loaded::class
    }

    @Test
    fun `should do nothing when onStart is called and viewModel state is not empty`() {
        testSubject.state = MovieDetailViewModelState.Loaded()

        testSubject.onStart(1)

        verify(movieDetailUseCase, never()).execute(any())
    }

    @Test
    fun `should call dispose when viewModel is cleared`() {
        testSubject.onCleared()

        verify(movieDetailUseCase).dispose()
    }
}