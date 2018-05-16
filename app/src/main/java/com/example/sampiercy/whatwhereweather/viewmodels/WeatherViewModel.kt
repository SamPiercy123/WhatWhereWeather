package com.example.sampiercy.whatwhereweather.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import com.example.sampiercy.whatwhereweather.data.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    private var weatherResponse: WeatherResponse? = null

    open fun getWeather(refresh: Boolean): Single<WeatherResponse> {
        if(!refresh) weatherResponse?.let { return Single.just(weatherResponse) }
        return weatherRepository.getWeatherAroundLocation().flatMap {
            setWeatherResponse(it)
            Single.just(it)
        }
    }

    fun setWeatherResponse(weatherResponse: WeatherResponse){
        this.weatherResponse = weatherResponse
    }
}