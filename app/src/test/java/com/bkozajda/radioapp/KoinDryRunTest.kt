package com.bkozajda.radioapp

import com.bkozajda.radioapp.di.AppModule
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesFragmentModule
import com.bkozajda.radioapp.presentation.main.di.MainActivityModule
import com.bkozajda.radioapp.presentation.movieDetail.di.MovieDetailFragmentModule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.test.KoinTest
import org.koin.test.dryRun

class KoinDryRunTest : KoinTest {

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `dryRun module`() {
        startKoin(listOf(AppModule, MainActivityModule, DiscoverMoviesFragmentModule, MovieDetailFragmentModule))
        dryRun()
    }
}