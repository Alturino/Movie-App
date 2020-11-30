package com.onirutla.submissiondicoding.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.ui.favorite.FavoriteActivity
import com.onirutla.submissiondicoding.utils.DataDummy
import com.onirutla.submissiondicoding.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FavoriteActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTv()

    @get:Rule
    var activityRule = ActivityScenarioRule(FavoriteActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadFavoriteMovieData() {
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size)
        )
    }

    @Test
    fun loadFavoriteTvData() {
        onView(ViewMatchers.withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_favorite_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size)
        )
    }

}