package com.bkozajda.radioapp.presentation.main.di

import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesFragment
import com.bkozajda.radioapp.presentation.discover.di.DiscoverMoviesFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [(DiscoverMoviesFragmentModule::class)])
    abstract fun discoverMoviesFragmentInjector(): DiscoverMoviesFragment
}
