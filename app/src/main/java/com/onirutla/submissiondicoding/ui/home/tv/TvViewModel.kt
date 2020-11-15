package com.onirutla.submissiondicoding.ui.home.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository

class TvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<MovieEntity>> = movieRepository.getAllTvShows()
}