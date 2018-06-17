package com.bkozajda.radioapp.presentation.main.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.bkozajda.radioapp.presentation.main.MainActivity

@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
