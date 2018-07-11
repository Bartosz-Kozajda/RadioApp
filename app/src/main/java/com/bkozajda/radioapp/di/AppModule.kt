package com.bkozajda.radioapp.di

import com.bkozajda.data.executor.JobExecutor
import com.bkozajda.data.mapper.DetailedMovieMapper
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.data.repository.MovieDataRepository
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.radioapp.BuildConfig
import com.bkozajda.radioapp.UiThread
import com.bkozajda.remote.di.RemoteModule
import com.bkozajda.remote.mapper.DetailedMovieEntityMapper
import com.bkozajda.remote.mapper.MovieEntityMapper
import com.bkozajda.remote.service.MovieService
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.koin.dsl.module.module

val AppModule = module {
    single { MovieMapper() }
    single { DetailedMovieMapper() }
    single { MovieEntityMapper() }
    single { DetailedMovieEntityMapper() }
    single { MovieDataRepository(get(), get(), get()) as MovieRepository }
    single { MovieService(get(), get(), get(), BuildConfig.API_KEY) as MovieRemote }
    single { RemoteModule.provideMovieService(BuildConfig.API_URL) }
    single<PostExecutionThread> { UiThread() }
    single<ThreadExecutor> { JobExecutor() }
}