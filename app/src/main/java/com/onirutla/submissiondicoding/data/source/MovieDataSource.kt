package com.onirutla.submissiondicoding.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.utils.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getAllTv(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>>
    fun getDetailTv(id: String): LiveData<Resource<MovieEntity>>
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<MovieEntity>>
    suspend fun setFavoriteMovie(movie: MovieEntity, state: Boolean)
}