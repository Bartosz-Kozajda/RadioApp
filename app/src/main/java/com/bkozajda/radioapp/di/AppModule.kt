package com.bkozajda.radioapp.di

import android.app.Application
import android.content.Context
import com.bkozajda.data.executor.JobExecutor
import com.bkozajda.data.mapper.MovieMapper
import com.bkozajda.data.repository.MovieDataRepository
import com.bkozajda.data.repository.MovieRemote
import com.bkozajda.radioapp.di.scopes.PerApplication
import com.bkozajda.remote.di.RemoteModule
import com.bkozajda.remote.mapper.MovieEntityMapper
import com.bkozajda.remote.service.MovieService
import com.bkozajda.remote.service.RetrofitMovieService
import dagger.Module
import dagger.Provides
import com.bkozajda.domain.repository.MovieRepository
import com.bkozajda.radioapp.UiThread
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor

@Module
open class AppModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context  = application

    @Provides
    @PerApplication
    fun provideMovieRepository(mapper: MovieMapper,
                               movieRemote: MovieRemote) : MovieRepository = MovieDataRepository(mapper, movieRemote)

    @Provides
    @PerApplication
    fun provideMovieRemote(service: RetrofitMovieService,
                           movieEntityMapper: MovieEntityMapper) : MovieRemote  = MovieService(service, movieEntityMapper)

    @Provides
    @PerApplication
    fun provideMovieService() : RetrofitMovieService = RemoteModule.provideMovieService()

/*    @Provides
    @PerApplication
    fun provideMovieMapper(): MovieMapper = MovieMapper()

    @Provides
    @PerApplication
    fun provideMovieEntityMapper(): MovieEntityMapper = MovieEntityMapper()*/

    @Provides
    @PerApplication
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}