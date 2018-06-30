package com.bkozajda.radioapp.presentation.main.di

import android.app.Activity
import com.bkozajda.radioapp.presentation.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [(MainActivityComponent::class)])
internal abstract class MainActivityBinder {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(builder: MainActivityComponent.Builder):
            AndroidInjector.Factory<out Activity>
}