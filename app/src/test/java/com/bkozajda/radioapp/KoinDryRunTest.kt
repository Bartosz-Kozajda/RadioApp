package com.bkozajda.radioapp

import com.bkozajda.radioapp.di.AppModule
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesFragmentModule
import com.bkozajda.radioapp.presentation.movieDetail.di.MovieDetailFragmentModule
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.test.KoinTest
import org.koin.test.dryRun

class KoinDryRunTest : KoinTest {
    @Test
    fun `dryRun module`() {
        startKoin(listOf(AppModule, DiscoverMoviesFragmentModule, MovieDetailFragmentModule))
        dryRun()
    }
}