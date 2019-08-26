package com.bkozajda.data.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.domain.model.Movie
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieMapperTest {

    val id = 1
    val title = "title"
    val voteAverage = 2.0
    val posterPath = "path"

    val tested = MovieMapper()

    @Test
    fun `should map movie from entity`() {
        val movieEntity = MovieEntity(id, title, voteAverage, posterPath)

        val result = tested.mapFromEntity(movieEntity)

        val expected = Movie(id, title, voteAverage, posterPath)
        result shouldEqual expected
    }

    @Test
    fun `should map movie to entity`() {
        val movie = Movie(id, title, voteAverage, posterPath)

        val result = tested.mapToEntity(movie)

        val expected = MovieEntity(id, title, voteAverage, posterPath)
        result shouldEqual expected
    }
}