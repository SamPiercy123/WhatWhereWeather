package com.example.sampiercy.whatwhereweather.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sampiercy.whatwhereweather.R
import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import com.example.sampiercy.whatwhereweather.ui.WeatherDetailActivity
import com.example.sampiercy.whatwhereweather.ui.viewholder.HomePageViewHolder
import kotlinx.android.synthetic.main.item_weather_simple.view.*

class HomePageAdapter(var weatherResponse: WeatherResponse, val context: Context) : RecyclerView.Adapter<HomePageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_weather_simple, parent, false)
        return HomePageViewHolder(itemView)
    }

    override fun getItemCount(): Int = weatherResponse.list.size

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        val weatherItem = weatherResponse.list[position]
        with(holder.itemView) {
            cityNameValue.text = weatherItem.name
            weatherTypeValue.text = weatherItem.weather[0].main
            temperatureValue.text = weatherItem.main.temp.toString()
            setOnClickListener({ WeatherDetailActivity.start(context, weatherItem) })
        }
    }
}