package com.onirutla.submissiondicoding.data.model.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.remote.RemoteDataSource
import com.onirutla.submissiondicoding.data.source.LocalDataSource
import com.onirutla.submissiondicoding.util.PagedListUtil
import com.onirutla.submissiondicoding.utils.AppExecutors
import com.onirutla.submissiondicoding.utils.DataDummy
import com.onirutla.submissiondicoding.utils.vo.Resource
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTv()).thenReturn(dataSourceFactory)
        movieRepository.getAllTv()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getAllTv()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovie()

        val favoriteMovieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(favoriteMovieEntities)
        assertEquals(movieResponses.size.toLong(), favoriteMovieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteTv()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShow()

        val favoriteTvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getFavoriteTv()
        assertNotNull(favoriteTvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), favoriteTvShowEntities.data?.size?.toLong())
    }
}