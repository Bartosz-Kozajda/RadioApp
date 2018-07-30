package com.bkozajda.remote.di

import com.bkozajda.remote.service.RetrofitMovieService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RemoteModule {

    fun provideMovieService(baseUrl: String): RetrofitMovieService {
        return provideMovieService(provideOkHttpClient(), provideMoshi(), baseUrl)
    }

    private fun provideMovieService(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String): RetrofitMovieService {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
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
                .add(KotlinJsonAdapterFactory())
                .build()
    }
}