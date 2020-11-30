package com.onirutla.submissiondicoding.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
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
class FavoriteMovieViewModelTest {
    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp(){
        viewModel = FavoriteMovieViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovie(){
        val dummyFavoriteMovie = pagedList
        `when`(dummyFavoriteMovie.size).thenReturn(5)
        val favoriteMovieData = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovieData.value = dummyFavoriteMovie

        `when`(movieRepository.getFavoriteMovie()).thenReturn(favoriteMovieData)
        val favoriteMovieTest = viewModel.getFavoriteMovie().value
        verify(movieRepository).getFavoriteMovie()
        assertNotNull(favoriteMovieTest)
        assertEquals(5, favoriteMovieTest?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyFavoriteMovie)
    }
}