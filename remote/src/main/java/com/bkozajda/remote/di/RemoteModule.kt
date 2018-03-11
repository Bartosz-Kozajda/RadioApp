package com.bkozajda.remote.di

import com.bkozajda.remote.service.RetrofitMovieService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RemoteModule {

    fun provideMovieService(): RetrofitMovieService {
        return provideMovieService(provideOkHttpClient(), provideGson())
    }

    private fun provideMovieService(okHttpClient: OkHttpClient, gson: Gson): RetrofitMovieService {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(RetrofitMovieService::class.java)
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    private fun provideGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }
}