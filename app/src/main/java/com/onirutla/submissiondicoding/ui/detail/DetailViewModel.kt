package com.onirutla.submissiondicoding.ui.detail

import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.data.model.TvEntity
import com.onirutla.submissiondicoding.utils.DataDummy

class DetailViewModel : ViewModel() {

    fun getDetailMovie(id: String?): MovieEntity?{
        var movieEntity: MovieEntity? = null
        val movies = DataDummy.generateDummyMovie()
        for(movie in movies){
            if(id == movie.id){
                movieEntity = movie
            }
        }
        return movieEntity
    }

    fun getDetailTv(id: String?): TvEntity? {
        var tvEntity: TvEntity? = null
        val tvList = DataDummy.generateDummyTv()
        for(tv in tvList){
            if(id == tv.id){
                tvEntity = tv
            }
        }
        return tvEntity
    }
}