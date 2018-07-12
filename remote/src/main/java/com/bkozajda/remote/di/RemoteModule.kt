package com.bkozajda.remote.di

import com.bkozajda.remote.service.RetrofitMovieService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RemoteModule {

    fun provideMovieService(baseUrl: String): RetrofitMovieService {
        return provideMovieService(provideOkHttpClient(), provideMoshi(), baseUrl)
    }

    private fun provideMovieService(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String): RetrofitMovieService {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        return retrofit.create(RetrofitMovieService::class.java)
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    private fun provideMoshi(): Moshi {
        return Moshi
                .Builder()
                .build()
    }
}