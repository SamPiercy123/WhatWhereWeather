package com.example.sampiercy.whatwhereweather.di

import com.example.sampiercy.whatwhereweather.ui.HomePageActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [HomePageActivityModule::class])
    abstract fun bindHomePageActivity(): HomePageActivity

}