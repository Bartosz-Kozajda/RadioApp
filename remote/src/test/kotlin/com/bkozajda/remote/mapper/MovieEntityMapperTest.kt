package com.bkozajda.remote.mapper

import com.bkozajda.data.model.MovieEntity
import com.bkozajda.remote.common.fromJson
import com.bkozajda.remote.model.MovieModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieEntityMapperTest {

    val tested = MovieEntityMapper()

    @Test
    fun `should map to entity from remote`() {
        val remote = fromJson<MovieModel>("models/movie.json")

        val result = tested.mapFromRemote(remote)

        val expected = MovieEntity(
            remote.id,
            remote.title,
            remote.vote_average,
            POSTER_URL_PREFIX + remote.poster_path
        )
        result shouldEqual expected
    }
}