package com.bkozajda.radioapp.presentation.movieDetail.di

import com.bkozajda.radioapp.di.scopes.PerFragment
import com.bkozajda.radioapp.presentation.movieDetail.view.MovieDetailFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent(modules = [(MovieDetailFragmentModule::class)])
interface MovieDetailFragmentComponent : AndroidInjector<MovieDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailFragment>()
}
