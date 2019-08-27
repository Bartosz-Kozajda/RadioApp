package com.bkozajda.domain.usecases.popular

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class PopularMoviesUseCaseTest {

    val repository = mock<MovieRepository>()

    val tested = PopularMoviesUseCase(repository)

    @Test
    fun `should return popular movies`() {
        val page = 1
        val movies = listOf(mock<Movie>())
        whenever(repository.popularMovies(page)).thenReturn(Single.just(movies))

        val result = tested.execute(page).test()

        result.assertValue(movies)
    }
}