package com.onirutla.submissiondicoding.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.source.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movieData = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movieData.value = dummyMovies

        `when`(movieRepository.getAllMovies()).thenReturn(movieData)
        val movieTest = viewModel.getAllMovies().value?.data
        verify(movieRepository).getAllMovies()
        assertNotNull(movieTest)
        assertEquals(5, movieTest?.size)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}