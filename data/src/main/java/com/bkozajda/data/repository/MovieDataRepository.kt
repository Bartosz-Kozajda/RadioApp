package com.bkozajda.data.repository

import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.domain.model.Movie
import io.reactivex.Single
import com.bkozajda.domain.repository.MovieRepository
import javax.inject.Inject

class MovieDataRepository @Inject constructor(private val movieMapper: MovieMapper,
                                      private val movieRemote: MovieRemote) : MovieRepository {
    override fun discoverMovies(apiKey: String, page: Int): Single<List<Movie>> {
        return movieRemote.discoverMovies(apiKey, page)
                .map {
                    it.map {
                        item -> movieMapper.mapFromEntity(item)
                    }
                }
    }
}
