package com.bkozajda.data.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.domain.model.DetailedMovie
import org.amshove.kluent.shouldEqual
import org.junit.Test

class DetailedMovieMapperTest {

    val adult = true
    val budget = 1
    val homepage = "homepage"
    val original_title = "title"
    val overview = "overview"
    val poster_path = "path"
    val release_date = "date"
    val title = "title"
    val vote_average = 2.0

    val tested = DetailedMovieMapper()

    @Test
    fun `should map detailed movie from entity`() {
        val movieEntity = DetailedMovieEntity(
            adult,
            budget,
            homepage,
            original_title,
            overview,
            poster_path,
            release_date,
            title,
            vote_average
        )

        val result = tested.mapFromEntity(movieEntity)

        val expected = DetailedMovie(
            adult,
            budget,
            homepage,
            original_title,
            overview,
            poster_path,
            release_date,
            title,
            vote_average
        )
        result shouldEqual expected
    }

    @Test
    fun `should map detailed movie to entity`() {
        val movie = DetailedMovie(
            adult,
            budget,
            homepage,
            original_title,
            overview,
            poster_path,
            release_date,
            title,
            vote_average
        )

        val result = tested.mapToEntity(movie)

        val expected = DetailedMovieEntity(
            adult,
            budget,
            homepage,
            original_title,
            overview,
            poster_path,
            release_date,
            title,
            vote_average
        )
        result shouldEqual expected
    }
}