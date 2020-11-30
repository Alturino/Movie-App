package com.onirutla.submissiondicoding.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()
}