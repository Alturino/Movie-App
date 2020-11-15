package com.onirutla.submissiondicoding.data.source

import androidx.lifecycle.LiveData
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.remote.MovieResponse

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(id: String): LiveData<MovieEntity>
    fun getAllTvShows(): LiveData<List<MovieEntity>>
    fun getDetailTvShow(id: String): LiveData<MovieEntity>
}