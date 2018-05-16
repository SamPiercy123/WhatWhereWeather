package com.example.sampiercy.whatwhereweather.ui

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.sampiercy.whatwhereweather.R
import com.example.sampiercy.whatwhereweather.atPosition
import com.example.sampiercy.whatwhereweather.getText
import org.hamcrest.CoreMatchers.startsWith
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class ClickThroughTests {


    @Rule
    @JvmField
    val landingActivity = ActivityTestRule<HomePageActivity>(HomePageActivity::class.java, true, true)

    @Test
    fun givenIHaveMockData_whenIClickFirstWeatherItem_thenShowCorrectWeatherType() {
        scrollAndClick(0)
        Espresso.onView(withId(R.id.weatherTypeValue)).check(matches(withText("Drizzle")))
    }

    @Test
    fun givenIHaveMockData_whenIClick10thWeatherItem_thenShowCorrectHumidity() {
        scrollAndClick(9)
        onView(withId(R.id.humidityValue)).check(matches(withText(startsWith("93"))))
        /*check(ViewAssertions.matches(ViewMatchers.withText(93)))*/
    }

    @Test
    fun givenIHaveMockData_whenIClickThroughRandomItem_thenTheTempStaysConsistent() {
        val randomCell = Random().nextInt(9)
        scrollAndClick(randomCell)
        val temp = onView(withId(R.id.temperatureValue)).getText()
        Espresso.pressBack()
        scrollTo(randomCell)
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(randomCell, hasDescendant(withText(temp)))));
    }


    fun scrollTo(cell: Int) {
        onView(withId(R.id.recyclerView)).perform(scrollToPosition<RecyclerView.ViewHolder>(cell))
    }

    fun scrollAndClick(cell: Int) {
        scrollTo(cell)
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(cell, ViewActions.click()))
    }


}