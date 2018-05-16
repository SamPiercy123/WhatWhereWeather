package com.example.sampiercy.whatwhereweather

import android.app.Application
import com.example.sampiercy.whatwhereweather.di.ActivityBuilder
import com.example.sampiercy.whatwhereweather.di.AppComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class,
    CoreTestModule::class, ActivityBuilder::class])
interface AppTestComponent : AppComponent{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
