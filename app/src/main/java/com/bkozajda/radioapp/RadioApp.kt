package com.bkozajda.radioapp

import android.app.Application
import com.bkozajda.radioapp.di.AppModule
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesFragmentModule
import com.bkozajda.radioapp.presentation.main.di.MainActivityModule
import com.bkozajda.radioapp.presentation.movieDetail.di.MovieDetailFragmentModule
import org.koin.android.ext.android.startKoin

class RadioApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                AppModule,
                MainActivityModule,
                DiscoverMoviesFragmentModule,
                MovieDetailFragmentModule)
        )
    }
}