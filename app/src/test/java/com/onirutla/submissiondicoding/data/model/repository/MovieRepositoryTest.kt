package com.onirutla.submissiondicoding.data.model.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.onirutla.submissiondicoding.data.model.remote.RemoteDataSource
import com.onirutla.submissiondicoding.ui.util.LiveDataProvider
import com.onirutla.submissiondicoding.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remoteDataSource)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShows()

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(
                movieResponse
            )
            null
        }.`when`(remoteDataSource).getAllMovie(any())

        val movieEntities = LiveDataProvider.getValue(movieRepository.getAllMovies())
        verify(remoteDataSource).getAllMovie(any())

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllTvShowReceived(
                tvShowResponse
            )
            null
        }.`when`(remoteDataSource).getAllTvShows(any())

        val tvShowEntities = LiveDataProvider.getValue(movieRepository.getAllTvShows())
        verify(remoteDataSource).getAllTvShows(any())

        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.size.toLong())
    }
}