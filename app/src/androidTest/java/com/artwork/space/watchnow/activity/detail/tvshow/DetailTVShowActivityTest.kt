package com.artwork.space.watchnow.activity.detail.tvshow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowActivity
import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowViewModel
import com.artwork.space.watchnow.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class DetailTVShowActivityTest {
    private val viewModel: DetailTVShowViewModel =
        DetailTVShowViewModel()
    private val dummyTVShow = DataDummy.generateDummyTvShow()[0]
    private val dummyImgUrl = dummyTVShow.imageUrl

    @get:Rule
    var activityRule = ActivityTestRule(DetailTVShowActivity::class.java)

    @Test
    fun isAllViewDisplayed() {
        viewModel.setTVShow(dummyImgUrl)
        viewModel.getTVShow()

        onView(withId(R.id.detail_tv_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_btn_back)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_iv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_tv_description)).check(matches(isDisplayed()))
    }
}