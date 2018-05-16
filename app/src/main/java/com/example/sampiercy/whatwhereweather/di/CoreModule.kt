package com.example.sampiercy.whatwhereweather.di

import android.app.Application
import com.example.sampiercy.whatwhereweather.api.WeatherApiService
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder



@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideWeatherApiService(okHttpClient: OkHttpClient, gson: Gson): WeatherApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(application: Application): OkHttpClient {
        val cacheSize: Long = 10 * 1024 * 1024
        val cache = Cache(application.getCacheDir(), cacheSize)
        return OkHttpClient.Builder().cache(cache)
                .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

}