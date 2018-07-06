package com.bkozajda.data.repository

import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.domain.model.Movie
import com.bkozajda.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val movieMapper: MovieMapper,
    private val movieRemote: MovieRemote
) : MovieRepository {
    override fun discoverMovies(page: Int): Observable<List<Movie>> {
        return movieRemote.discoverMovies(page)
                .map {
                    it.map {
                        item -> movieMapper.mapFromEntity(item)
                    }
                }
    }
}
