package com.onirutla.submissiondicoding.ui.home

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTv = DataDummy.generateDummyTv()
    private val intent =
        Intent(ApplicationProvider.getApplicationContext(), HomeActivity::class.java)

    @get:Rule
    var activityRule = ActivityScenarioRule<HomeActivity>(intent)

    @Test
    fun loadMovieData() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.detail_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_description)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_image)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvData() {
        onView(withText(R.string.header_tv_show)).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadTvDetail() {
        onView(withText(R.string.header_tv_show)).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.detail_title)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_description)).check(matches(withText(dummyTv[0].description)))
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_image)).check(matches(isDisplayed()))
    }
}