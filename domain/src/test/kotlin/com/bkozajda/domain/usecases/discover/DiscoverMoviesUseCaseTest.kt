package com.bkozajda.domain.usecases.discover

import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class DiscoverMoviesUseCaseTest {

    val repository = mock<MovieRepository>()

    val tested = DiscoverMoviesUseCase(repository)

    @Test
    fun `should return discover movies`() {
        val page = 1
        val movies = listOf(mock<Movie>())
        whenever(repository.discoverMovies(page)).thenReturn(Single.just(movies))

        val result = tested.execute(page).test()

        result.assertValue(movies)
    }
}