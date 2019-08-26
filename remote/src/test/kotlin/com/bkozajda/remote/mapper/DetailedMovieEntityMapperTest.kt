package com.bkozajda.remote.mapper

import com.bkozajda.data.model.DetailedMovieEntity
import com.bkozajda.remote.common.fromJson
import com.bkozajda.remote.model.DetailedMovieModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class DetailedMovieEntityMapperTest {

    val tested = DetailedMovieEntityMapper()

    @Test
    fun `should map to entity from remote`() {
        val remote = fromJson<DetailedMovieModel>("models/detailed_movie.json")

        val result = tested.mapFromRemote(remote)

        val expected = DetailedMovieEntity(
            remote.adult,
            remote.budget,
            remote.homepage,
            remote.original_title,
            remote.overview,
            POSTER_URL_PREFIX + remote.poster_path,
            remote.release_date,
            remote.title,
            remote.vote_average
        )
        result shouldEqual expected
    }
}