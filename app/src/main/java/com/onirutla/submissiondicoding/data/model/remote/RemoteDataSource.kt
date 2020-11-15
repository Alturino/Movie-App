package com.onirutla.submissiondicoding.data.model.remote

import android.os.Handler
import com.onirutla.submissiondicoding.utils.EspressoIdlingResource
import com.onirutla.submissiondicoding.utils.JsonHelper

class RemoteDataSource(private val jsonHelper: JsonHelper) {
    private val handler = Handler()

    companion object {
        const val serviceLatency: Long = 300
    }

    fun getAllMovie(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, serviceLatency)
    }

    fun getAllTvShows(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, serviceLatency)
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<MovieResponse>)
    }
}