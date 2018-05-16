package com.example.sampiercy.whatwhereweather

import android.app.Activity
import android.app.Application
import com.example.sampiercy.whatwhereweather.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class WeatherApplication: Application(), HasActivityInjector {

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        initialiseDaggerComponent()
    }

    open fun initialiseDaggerComponent() = DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    override fun activityInjector(): AndroidInjector<Activity>
            = activityDispatchingAndroidInjector
}