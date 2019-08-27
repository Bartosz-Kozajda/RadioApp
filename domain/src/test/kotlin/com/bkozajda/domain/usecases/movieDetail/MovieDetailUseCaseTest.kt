package com.bkozajda.domain.usecases.movieDetail

import com.bkozajda.domain.model.DetailedMovie
import com.bkozajda.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class MovieDetailUseCaseTest {

    val repository = mock<MovieRepository>()

    val tested = MovieDetailUseCase(repository)

    @Test
    fun `should return detailed movie`() {
        val movieId = 1
        val movie = mock<DetailedMovie>()
        whenever(repository.detailedMovie(movieId)).thenReturn(Single.just(movie))

        val result = tested.execute(movieId).test()

        result.assertValue(movie)
    }
}