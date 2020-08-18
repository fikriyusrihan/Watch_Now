package com.artwork.space.watchnow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun isBottomNavigationVisible() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
    }

    @Test
    fun isFragmentVisible() {
        onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))
    }
}