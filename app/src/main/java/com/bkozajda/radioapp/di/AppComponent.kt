package com.bkozajda.radioapp.di

import android.app.Application
import com.bkozajda.radioapp.RadioApp
import com.bkozajda.radioapp.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = arrayOf(
        ActivityBuilder::class,
        AppModule::class,
        AndroidSupportInjectionModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: RadioApp)
}