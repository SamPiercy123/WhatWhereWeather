package com.example.sampiercy.whatwhereweather.di

import com.example.sampiercy.whatwhereweather.data.repository.WeatherRepository
import com.example.sampiercy.whatwhereweather.viewmodels.WeatherViewModel
import dagger.Module
import dagger.Provides

@Module
class HomePageActivityModule {

    @Provides
    fun provideWeatherViewModel(weatherRepository: WeatherRepository) = WeatherViewModel(weatherRepository)

}