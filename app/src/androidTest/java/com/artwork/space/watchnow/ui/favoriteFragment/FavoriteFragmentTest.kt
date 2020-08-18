package com.artwork.space.watchnow.ui.favoriteFragment

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
import com.artwork.space.watchnow.ui.movieFragment.MovieFragment
import com.artwork.space.watchnow.ui.tvshowFragment.TVShowFragment
import com.artwork.space.watchnow.utils.EspressoIdlingResource
import com.builder.watch.testing.SingleFragmentActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteFragmentTest {
    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)
    private val favoriteFragment = FavoriteFragment()
    private val movieFragment = MovieFragment()
    private val tvShowFragment = TVShowFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun addOneFavoriteMovieThenDelete() {
        activityRule.activity.setFragment(movieFragment)
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

        onView(withId(R.id.detail_movie_btn_favorite)).perform(click())
        onView(withId(R.id.detail_movie_btn_back)).perform(click())

        activityRule.activity.setFragment(favoriteFragment)
        onView(withId(R.id.favorite_recycler_view_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.favorite_recycler_view_movie)).perform(
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

        onView(withId(R.id.detail_movie_btn_favorite)).perform(click())
        onView(withId(R.id.detail_movie_btn_back)).perform(click())

        onView(withId(R.id.favorite_tv_message_no_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun addOneFavoriteTVShowThenDelete() {
        activityRule.activity.setFragment(tvShowFragment)
        onView(withId(R.id.main_tv_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.main_tv_recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.detail_tv_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_btn_back)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_rating)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_tv_btn_favorite)).perform(click())
        onView(withId(R.id.detail_tv_btn_back)).perform(click())

        activityRule.activity.setFragment(favoriteFragment)
        onView(withId(R.id.favorite_recycler_view_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.favorite_recycler_view_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.detail_tv_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_btn_back)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_rating)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_tv_btn_favorite)).perform(click())
        onView(withId(R.id.detail_tv_btn_back)).perform(click())

        onView(withId(R.id.favorite_tv_message_no_tv)).check(matches(isDisplayed()))

    }
}