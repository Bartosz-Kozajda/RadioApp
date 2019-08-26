package com.bkozajda.remote.service

import com.bkozajda.remote.model.DetailedMovieModel
import com.bkozajda.remote.model.DiscoverModel
import com.bkozajda.remote.model.PopularModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitMovieService {
    @GET("discover/movie")
    fun discoverMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Single<DiscoverModel>

    @GET("movie/popular")
    fun popularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Single<PopularModel>

    @GET("movie/{movie_id}")
    fun detailedMovie(
        @Path("movie_id") page: Int,
        @Query("api_key") apiKey: String
    ): Single<DetailedMovieModel>
}