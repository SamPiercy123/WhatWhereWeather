package com.example.sampiercy.whatwhereweather.api

import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    val authenticationToken: String
        get() = "ef5720ec056bc41920ec2f76b928c454"

    @GET("data/2.5/find")
    fun findWeatherForCitiesInCircle(@Query("lat") latitude: Float, @Query("lon") longitude: Float,
                                     @Query("cnt") numberOfCities: Int,
                                     @Query("APPID") authorizationToken: String = "ef5720ec056bc41920ec2f76b928c454"): Single<WeatherResponse>

}