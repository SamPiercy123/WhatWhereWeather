package com.example.sampiercy.whatwhereweather

class CorrectTestApiApplication:  WeatherApplication(){

    override fun initialiseDaggerComponent() {
        DaggerAppTestComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

}