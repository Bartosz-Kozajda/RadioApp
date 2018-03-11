package com.bkozajda.remote.service

import com.bkozajda.remote.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitMovieService {
    @GET("discover/movie")
    fun discoverMovies(@Query("api_key") apiKey: String,
                       @Query("page") page: Int): Single<List<MovieModel>>
}