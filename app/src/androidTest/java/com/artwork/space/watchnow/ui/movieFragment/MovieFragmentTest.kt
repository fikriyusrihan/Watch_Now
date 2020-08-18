package com.artwork.space.watchnow.ui.movieFragment

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.utils.EspressoIdlingResource
import com.builder.watch.testing.SingleFragmentActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)
    private val movieFragment = MovieFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(movieFragment)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun isAllDisplayed() {
        onView(withId(R.id.fragment_movie_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment_movie_secondary_title)).check(matches(isDisplayed()))
        onView(withId(R.id.main_movies_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.main_movies_recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun clickFirstElementInRecyclerView() {
        onView(withId(R.id.main_movies_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.main_movies_recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.detail_movie_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_btn_back)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_iv_rating)).check(matches(isDisplayed()))

    }

}