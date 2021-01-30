package com.onirutla.submissiondicoding.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onirutla.submissiondicoding.data.model.remote.ApiResponse
import com.onirutla.submissiondicoding.data.model.remote.MovieResponse
import com.onirutla.submissiondicoding.utils.EspressoIdlingResource
import com.onirutla.submissiondicoding.utils.JsonHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemoteDataSource(private val jsonHelper: JsonHelper) {

    fun getAllMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }
        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch{
            resultTv.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }
        return resultTv
    }
}