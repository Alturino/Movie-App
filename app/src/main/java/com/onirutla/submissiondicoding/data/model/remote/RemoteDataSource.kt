package com.onirutla.submissiondicoding.data.model.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onirutla.submissiondicoding.utils.EspressoIdlingResource
import com.onirutla.submissiondicoding.utils.JsonHelper

class RemoteDataSource(private val jsonHelper: JsonHelper) {
    private val handler = Handler()

    companion object {
        const val serviceLatency: Long = 300
    }

    fun getAllMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, serviceLatency)
        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultTv.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, serviceLatency)
        return resultTv
    }
}