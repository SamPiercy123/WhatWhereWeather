package com.example.sampiercy.whatwhereweather.data.repository

import com.example.sampiercy.whatwhereweather.api.WeatherApiService
import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
open class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService) {

    open fun getWeatherAroundLocation(): Single<WeatherResponse> =
            weatherApiService.findWeatherForCitiesInCircle(53.4f, 2.2f, 10)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}