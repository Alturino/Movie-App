package com.onirutla.submissiondicoding.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setMovieId(id: String) {
        this.movieId = id
    }

    fun setTvId(id: String) {
        this.tvShowId = id
    }

    fun getMovieDetailById(): LiveData<MovieEntity> = movieRepository.getDetailMovie(movieId)

    fun getTvShowDetailById(): LiveData<MovieEntity> = movieRepository.getDetailTvShow(tvShowId)
}