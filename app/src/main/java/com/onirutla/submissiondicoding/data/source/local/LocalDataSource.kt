package com.onirutla.submissiondicoding.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.source.local.db.MovieDao

class LocalDataSource(private val movieDao: MovieDao) {
    suspend fun insertMovies(movie: List<MovieEntity>) = movieDao.insertMovies(movie)
    fun getMovieList(): DataSource.Factory<Int, MovieEntity> = movieDao.getMovieList()
    fun getTvList(): DataSource.Factory<Int, MovieEntity> = movieDao.getTvList()
    fun getMovieDetail(id: String): LiveData<MovieEntity> = movieDao.getMovieDetail(id)
    fun getTvDetail(id: String): LiveData<MovieEntity> = movieDao.getTvDetail(id)
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()
    fun getFavoriteTv(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteTv()

    suspend fun setFavorite(movie: MovieEntity, newState: Boolean) {
        movie.is_favorite = newState
        movieDao.setFavorite(movie)
    }
}