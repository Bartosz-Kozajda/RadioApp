package com.bkozajda.radioapp.presentation.discover.di

import androidx.fragment.app.Fragment
import com.bkozajda.radioapp.presentation.discover.view.DiscoverMoviesFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [(DiscoverMoviesFragmentComponent::class)])
abstract class DiscoverMoviesFragmentBinder {
    @Binds
    @IntoMap
    @FragmentKey(DiscoverMoviesFragment::class)
    abstract fun bindDiscoverMoviesFragmentInjectorFactory(builder: DiscoverMoviesFragmentComponent.Builder):
            AndroidInjector.Factory<out Fragment>
}