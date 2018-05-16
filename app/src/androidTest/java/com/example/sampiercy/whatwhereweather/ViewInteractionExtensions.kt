package com.example.sampiercy.whatwhereweather

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import android.view.View
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.support.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


fun ViewInteraction.getText(): String {
    var string = ""
    this.perform(object : ViewAction {
        override fun getConstraints() = isAssignableFrom(TextView::class.java)

        override fun getDescription() = "Get text from View: $string"

        override fun perform(uiController: UiController, view: View) {
            val tv = view as TextView
            string = tv.text.toString()
        }
    })
    return string
}

fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
    checkNotNull(itemMatcher)
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
            return itemMatcher.matches(viewHolder.itemView)
        }
    }
}