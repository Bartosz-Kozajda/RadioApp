package com.bkozajda.radioapp.presentation.movieDetail.di

import androidx.fragment.app.Fragment
import com.bkozajda.radioapp.presentation.movieDetail.view.MovieDetailFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [(MovieDetailFragmentComponent::class)])
abstract class MovieDetailFragmentBinder {
    @Binds
    @IntoMap
    @FragmentKey(MovieDetailFragment::class)
    abstract fun bindMovieDetailFragmentInjectorFactory(builder: MovieDetailFragmentComponent.Builder):
            AndroidInjector.Factory<out androidx.fragment.app.Fragment>
}