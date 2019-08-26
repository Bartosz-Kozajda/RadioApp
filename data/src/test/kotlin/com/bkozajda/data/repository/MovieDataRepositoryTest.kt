package com.bkozajda.data.repository

import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.data.model.MovieEntity
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class MovieDataRepositoryTest {

    val movieMapper = MovieMapper()
    val detailedMovieMapper = DetailedMovieMapper()
    val movieRemote = mock<MovieRemote>()

    val tested = MovieDataRepository(movieMapper, detailedMovieMapper, movieRemote)

    @Test
    fun `should return list of movie domain models from discover endpoint`() {
        val page = 1
        val movies = givenMovies()
        whenever(movieRemote.discoverMovies(page)).thenReturn(Single.just(movies))

        val result = tested.discoverMovies(page).test()

        val expected = movies.map { movieMapper.mapFromEntity(it) }
        result.assertValue(expected)
    }

    @Test
    fun `should return list of movie domain models from popular endpoint`() {
        val page = 1
        val movies = givenMovies()
        whenever(movieRemote.popularMovies(page)).thenReturn(Single.just(movies))

        val result = tested.popularMovies(page).test()

        val expected = movies.map { movieMapper.mapFromEntity(it) }
        result.assertValue(expected)
    }

    @Test
    fun `should return detailed movie domain model`() {
        val movieId = 1
        val detailedMovie = givenDetailedMovie()
        whenever(movieRemote.detailedMovie(movieId)).thenReturn(Single.just(detailedMovie))

        val result = tested.detailedMovie(movieId).test()

        val expected = detailedMovieMapper.mapFromEntity(detailedMovie)
        result.assertValue(expected)
    }

    private fun givenMovies(): List<MovieEntity> {
        val movie = MovieEntity(id = 1, title = "title", voteAverage = 2.0, posterPath = "path")
        return listOf(movie)
    }

    private fun givenDetailedMovie(): DetailedMovieEntity =
        DetailedMovieEntity(
            adult = true,
            budget = 1,
            homepage = "homepage",
            original_title = "title",
            overview = "overview",
            poster_path = "poster",
            release_date = "release",
            title = "title",
            vote_average = 1.0
        )
}