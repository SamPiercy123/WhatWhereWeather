package com.example.sampiercy.whatwhereweather.viewmodels

import com.example.sampiercy.whatwhereweather.WEATHER_INT
import com.example.sampiercy.whatwhereweather.WEATHER_STRING
import com.example.sampiercy.whatwhereweather.createWeatherResponse
import com.example.sampiercy.whatwhereweather.data.model.WeatherResponse
import com.example.sampiercy.whatwhereweather.data.repository.WeatherRepository
import com.example.sampiercy.whatwhereweather.utils.RxImmediateSchedulerRule
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class WeatherViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun givenIHaveValidData_whenIGetWeather_thenResponseShouldBeInitialised() {

        val weatherResponse = createWeatherResponse(3)
        `when`(weatherRepository.getWeatherAroundLocation()).thenReturn(Single.just(weatherResponse))

        val response = WeatherViewModel(weatherRepository).getWeather(false)

        val testObserver = TestObserver<WeatherResponse>()
        response.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val weatherOut = testObserver.values()[0]
        assertTrue(weatherOut.list.size == 3)
        assertTrue(weatherOut.list[0].name == WEATHER_STRING + 0)
        assertTrue(weatherOut.list[2].clouds.all == WEATHER_INT + 2)

    }

    @Test
    fun givenIHaveAndError_whenIGetWeather_thenResponseShouldGiveError() {

        val exception = Exception()

        `when`(weatherRepository.getWeatherAroundLocation()).thenReturn(Single.error(exception))

        val response = WeatherViewModel(weatherRepository).getWeather(false)

        val testObserver = TestObserver<WeatherResponse>()
        response.subscribe(testObserver)
        testObserver.assertError(exception)

    }


}