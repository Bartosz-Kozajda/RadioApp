package com.bkozajda.radioapp.presentation.discover.di

import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent(modules = [(DiscoverMoviesFragmentModule::class)])
interface DiscoverMoviesFragmentComponent : AndroidInjector<DiscoverMoviesFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DiscoverMoviesFragment>()
}
