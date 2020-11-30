package com.onirutla.submissiondicoding.ui.home.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.vo.Resource

class TvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllTv()
}