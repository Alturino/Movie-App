package com.onirutla.submissiondicoding.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.onirutla.submissiondicoding.data.model.local.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie_entities WHERE type = 'movie'")
    fun getMovieList(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE type = 'tv-show'")
    fun getTvList(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE id =:id AND type = 'movie'")
    fun getMovieDetail(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE id =:id AND type = 'tv-show'")
    fun getTvDetail(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE type = 'movie' AND is_favorite")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE type = 'tv-show' AND is_favorite")
    fun getFavoriteTv(): DataSource.Factory<Int, MovieEntity>

    @Update
    fun setFavorite(movie: MovieEntity)
}