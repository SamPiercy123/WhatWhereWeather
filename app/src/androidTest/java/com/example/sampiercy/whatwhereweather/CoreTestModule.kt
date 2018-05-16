package com.example.sampiercy.whatwhereweather

import com.example.sampiercy.whatwhereweather.api.WeatherApiService
import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CoreTestModule {

    @Provides
    @Singleton
    fun provideWeatherApiService(): WeatherApiService {

        return MockWeatherApiService()
    }
}

class MockWeatherApiService : WeatherApiService {
    override fun findWeatherForCitiesInCircle(latitude: Float, longitude: Float, numberOfCities: Int, authorizationToken: String): Single<WeatherResponse> {

        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val weatherResponse = gson.fromJson<WeatherResponse>("{\"message\":\"accurate\",\"cod\":\"200\",\"count\":10,\"list\":[{\"id\":2640766,\"name\":\"Overstrand\",\"coord\":{\"lat\":52.9162,\"lon\":1.339},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2651930,\"name\":\"Cromer\",\"coord\":{\"lat\":52.9312,\"lon\":1.2989},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2641966,\"name\":\"Mundesley\",\"coord\":{\"lat\":52.8622,\"lon\":1.3955},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2638019,\"name\":\"Sheringham\",\"coord\":{\"lat\":52.9408,\"lon\":1.2093},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2637110,\"name\":\"Stalham\",\"coord\":{\"lat\":52.7708,\"lon\":1.5178},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2641233,\"name\":\"North Walsham\",\"coord\":{\"lat\":52.8212,\"lon\":1.3875},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2647123,\"name\":\"Hemsby\",\"coord\":{\"lat\":52.6971,\"lon\":1.6918},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2642959,\"name\":\"Martham\",\"coord\":{\"lat\":52.7046,\"lon\":1.6364},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2640912,\"name\":\"Ormesby Saint Margaret\",\"coord\":{\"lat\":52.6667,\"lon\":1.7},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]},{\"id\":2654044,\"name\":\"Caister-on-Sea\",\"coord\":{\"lat\":52.6481,\"lon\":1.7265},\"main\":{\"temp\":284.15,\"pressure\":1020,\"humidity\":93,\"temp_min\":284.15,\"temp_max\":284.15},\"dt\":1526329200,\"wind\":{\"speed\":4.1,\"deg\":360},\"sys\":{\"country\":\"\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":75},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"}]}]}", WeatherResponse::class.java)
        return Single.just(weatherResponse)
    }
}



