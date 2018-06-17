package com.bkozajda.radioapp.di

import com.bkozajda.radioapp.di.scopes.PerActivity
import com.bkozajda.radioapp.presentation.main.MainActivity
import com.bkozajda.radioapp.presentation.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}