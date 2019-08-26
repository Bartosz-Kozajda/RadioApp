package com.bkozajda.remote.service

import com.bkozajda.remote.common.fromJson
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import com.bkozajda.remote.model.DetailedMovieModel
import com.bkozajda.remote.model.DiscoverModel
import com.bkozajda.remote.model.PopularModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class MovieServiceTest {

    val retrofitMovieService = mock<RetrofitMovieService>()
    val movieEntityMapper = MovieEntityMapper()
    val detailedMovieEntityMapper = DetailedMovieEntityMapper()
    val apiKey = "apiKey"

    val tested =
        MovieService(retrofitMovieService, movieEntityMapper, detailedMovieEntityMapper, apiKey)

    @Test
    fun `should return list of movie entities from discover endpoint`() {
        val page = 1
        val movies = givenDiscoverMovies()
        whenever(retrofitMovieService.discoverMovies(apiKey, page)).thenReturn(Single.just(movies))

        val result = tested.discoverMovies(page).test()

        val expected = movies.results.map {
            movieEntityMapper.mapFromRemote(it)
        }
        result.assertValue(expected)
    }

    @Test
    fun `should return list of movie entities from popular endpoint`() {
        val page = 1
        val movies = givenPopularMovies()
        whenever(retrofitMovieService.popularMovies(apiKey, page)).thenReturn(Single.just(movies))

        val result = tested.popularMovies(page).test()

        val expected = movies.results.map {
            movieEntityMapper.mapFromRemote(it)
        }
        result.assertValue(expected)
    }

    @Test
    fun `should return detailed movie entity`() {
        val movieId = 1
        val movie = givenDetailedMovie()
        whenever(retrofitMovieService.detailedMovie(movieId, apiKey))
            .thenReturn(Single.just(movie))

        val result = tested.detailedMovie(movieId).test()

        val expected = detailedMovieEntityMapper.mapFromRemote(movie)
        result.assertValue(expected)
    }

    private fun givenDiscoverMovies(): DiscoverModel =
        fromJson("models/discover_movies.json")

    private fun givenPopularMovies(): PopularModel =
        fromJson("models/popular_movies.json")

    private fun givenDetailedMovie(): DetailedMovieModel =
        fromJson("models/detailed_movie.json")
}