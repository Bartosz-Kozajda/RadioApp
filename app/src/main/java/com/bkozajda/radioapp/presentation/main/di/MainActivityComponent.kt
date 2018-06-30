package com.bkozajda.radioapp.presentation.main.di

import com.bkozajda.radioapp.di.scopes.PerActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.bkozajda.radioapp.presentation.main.MainActivity

@PerActivity
@Subcomponent(modules = [(MainActivityModule::class)])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
