package com.artwork.space.watchnow.activity.detail.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailMovieActivityTest {
    private val viewModel: DetailMovieViewModel = DetailMovieViewModel()
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyUrl = dummyMovie.imageUrl

    @get:Rule
    var activityRule = ActivityTestRule(DetailMovieActivity::class.java)

    @Test
    fun isAllViewDisplayed() {
        viewModel.setMovie(dummyUrl)
        viewModel.getMovie()

        onView(withId(R.id.detail_movie_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_btn_back)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_iv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_tv_description)).check(matches(isDisplayed()))
    }
}