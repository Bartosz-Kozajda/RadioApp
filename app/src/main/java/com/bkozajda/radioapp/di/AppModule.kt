package com.bkozajda.radioapp.di

import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.data.repository.MovieDataRepository
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.domain.executor.PostExecutionThread
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.radioapp.BuildConfig
import com.bkozajda.radioapp.UiThread
import com.bkozajda.remote.di.RemoteModule
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import com.bkozajda.remote.service.MovieService
import org.koin.dsl.module.module

val AppModule = module {
    single { MovieMapper() }
    single { DetailedMovieMapper() }
    single { MovieEntityMapper() }
    single { DetailedMovieEntityMapper() }
    single<MovieRepository> { MovieDataRepository(get(), get(), get()) }
    single<MovieRemote> { MovieService(get(), get(), get(), BuildConfig.API_KEY) }
    single { RemoteModule.provideMovieService(BuildConfig.API_URL) }
    single<PostExecutionThread> { UiThread() }
}