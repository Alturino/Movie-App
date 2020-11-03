package com.onirutla.submissiondicoding.ui.home.movie

import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}