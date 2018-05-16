package com.example.sampiercy.whatwhereweather

import com.example.sampiercy.whatwhereweather.data.model.*
import java.util.*

val WEATHER_INT = 33
val WEATHER_FLOAT = 1.5f
val WEATHER_STRING = "whatever_the_weather"
val WEATHER_LONG: Long = 231231312233


fun createWeatherResponse(numWeatherItem: Int): WeatherResponse {

    var weatherResponse = WeatherResponse(LinkedList())

    repeat(numWeatherItem, {
        val clouds = Clouds(WEATHER_INT + it)
        val coords = Coord(WEATHER_FLOAT + it, WEATHER_FLOAT + it)
        val main = Main(WEATHER_INT + it, WEATHER_INT + it, WEATHER_FLOAT + it, WEATHER_FLOAT + it, WEATHER_FLOAT + it)
        val weather = Weather("$WEATHER_STRING$it", "$WEATHER_STRING$it", WEATHER_INT, "$WEATHER_STRING$it")
        val weatherList = Collections.singletonList(weather)
        val wind = Wind(WEATHER_INT + it, WEATHER_FLOAT + it)
        val weatherItem = WeatherItem(clouds, coords, WEATHER_LONG, WEATHER_INT+it, main, "$WEATHER_STRING$it", weatherList, wind)

        weatherResponse.list.add(weatherItem)
    })

    return weatherResponse
}