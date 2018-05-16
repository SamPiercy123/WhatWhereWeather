package com.example.sampiercy.whatwhereweather.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sampiercy.whatwhereweather.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherViewModelFactory @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepository) as T
    }

}