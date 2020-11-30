package com.onirutla.submissiondicoding.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.db.MovieDao

class LocalDataSource(private val movieDao: MovieDao) {
    fun insertMovies(movie: List<MovieEntity>) = movieDao.insertMovies(movie)
    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getMovieList()
    fun getAllTv(): DataSource.Factory<Int, MovieEntity> = movieDao.getTvList()
    fun getMovieDetail(id: String): LiveData<MovieEntity> = movieDao.getMovieDetail(id)
    fun getTvDetail(id: String): LiveData<MovieEntity> = movieDao.getTvDetail(id)
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()
    fun getFavoriteTv(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteTv()

    fun setFavorite(movie: MovieEntity, newState: Boolean) {
        movie.is_favorite = newState
        movieDao.setFavorite(movie)
    }
}