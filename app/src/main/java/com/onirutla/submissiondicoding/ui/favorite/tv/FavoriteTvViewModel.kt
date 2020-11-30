package com.onirutla.submissiondicoding.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository

class FavoriteTvViewModel(private val movieRepository: MovieRepository): ViewModel(){
    fun getFavoriteTvShow(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteTvShow()
}
