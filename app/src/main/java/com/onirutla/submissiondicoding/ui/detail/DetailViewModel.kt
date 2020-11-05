package com.onirutla.submissiondicoding.ui.detail

import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.data.model.TvEntity
import com.onirutla.submissiondicoding.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId : String
    private lateinit var tvId :String

    private fun getListMovieDetail(): ArrayList<MovieEntity> = DataDummy.generateDummyMovie() as ArrayList<MovieEntity>

    private fun getListTvDetail(): ArrayList<TvEntity> = DataDummy.generateDummyTv() as ArrayList<TvEntity>

    fun setMovieId(movieId : String){
        this.movieId = movieId
    }

    fun setTvId(tvId: String){
        this.tvId = tvId
    }

    fun getMovieDetailById(): MovieEntity{
        lateinit var movieEntity: MovieEntity
        val movies = getListMovieDetail()
        for(movie in movies){
            if(movie.id == movieId){
                movieEntity = movie
            }
        }
        return movieEntity
    }

    fun getTvDetailById(): TvEntity {
        lateinit var tvEntity: TvEntity
        val listTv = getListTvDetail()
        for(tv in listTv){
            if(tv.id == tvId){
                tvEntity = tv
            }
        }
        return tvEntity
    }
}