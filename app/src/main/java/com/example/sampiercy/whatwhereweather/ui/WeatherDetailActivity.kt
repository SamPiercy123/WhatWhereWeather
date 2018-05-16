package com.example.sampiercy.whatwhereweather.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sampiercy.whatwhereweather.R
import com.example.sampiercy.whatwhereweather.data.model.WeatherItem
import kotlinx.android.synthetic.main.activity_weather_detail.*

class WeatherDetailActivity : AppCompatActivity() {

    companion object {
        const val WEATHER_ITEM_EXTRA = "weather_item_extra"

        fun start(context: Context, weatherItem: WeatherItem) {
            val intent = Intent(context, WeatherDetailActivity::class.java)
            intent.putExtra(WEATHER_ITEM_EXTRA, weatherItem)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)
        val weatherItem = intent.getParcelableExtra<WeatherItem>(WEATHER_ITEM_EXTRA)
        weatherDetailTitle.text = String.format(getString(R.string.weather_detail_title), weatherItem.name)
        weatherTypeValue.text = weatherItem.weather[0].main
        temperatureValue.text = weatherItem.main.temp.toString()
        humidityValue.text =  "${weatherItem.main.humidity} humidity units XD"
        windSpeedValue.text = "${weatherItem.wind.speed} km/h"
        cloudCoverValue.text = "${weatherItem.clouds.all}%"

    }

}