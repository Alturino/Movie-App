package com.onirutla.submissiondicoding.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.vo.Resource

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var movieId = MutableLiveData<String>()
    private var tvShowId = MutableLiveData<String>()

    fun setFavorite() {
        val resourceMovie = movie.value
        val resourceTvShow = tv.value

        resourceMovie?.let {
            val movieData = it.data
            movieData?.let {
                val newState = !movieData.is_favorite
                movieRepository.setFavoriteMovie(movieData, newState)
            }
        }

        resourceTvShow?.let {
            val tvShowData = it.data
            tvShowData?.let {
                val newState = !tvShowData.is_favorite
                movieRepository.setFavoriteMovie(tvShowData, newState)
            }
        }
    }

    fun setMovieId(id: String) {
        this.movieId.value = id
    }

    fun setTvId(id: String) {
        this.tvShowId.value = id
    }

    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) {
        movieRepository.getDetailMovie(it)
    }

    var tv: LiveData<Resource<MovieEntity>> = Transformations.switchMap(tvShowId) {
        movieRepository.getDetailTv(it)
    }
}