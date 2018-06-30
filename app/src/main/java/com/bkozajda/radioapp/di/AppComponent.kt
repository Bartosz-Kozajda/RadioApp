package com.bkozajda.radioapp.di

import com.bkozajda.radioapp.RadioApp
import com.bkozajda.radioapp.di.scopes.PerApplication
import com.bkozajda.radioapp.presentation.main.di.MainActivityBinder
import dagger.Component

@PerApplication
@Component(modules = [(MainActivityBinder::class), (AppModule::class)])
interface AppComponent {
    fun inject(app: RadioApp)
}