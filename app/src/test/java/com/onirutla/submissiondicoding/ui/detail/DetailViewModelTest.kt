package com.onirutla.submissiondicoding.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.DataDummy
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTv()[0]

    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(moviesRepository)
        viewModel.setMovieId(movieId)
        viewModel.setTvId(tvShowId)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(moviesRepository.getDetailMovie(movieId)).thenReturn(movie)
        val testEntity = viewModel.getMovieDetailById().value as MovieEntity
        verify(moviesRepository).getDetailMovie(movieId)

        assertNotNull(testEntity)
        assertEquals(dummyMovie.id, testEntity.id)
        assertEquals(dummyMovie.type, testEntity.type)
        assertEquals(dummyMovie.title, testEntity.title)
        assertEquals(dummyMovie.genre, testEntity.genre)
        assertEquals(dummyMovie.poster, testEntity.poster)
        assertEquals(dummyMovie.year, testEntity.year)
        assertEquals(dummyMovie.rating, testEntity.rating, 0.01)
        assertEquals(dummyMovie.description, testEntity.description)
        assertEquals(dummyMovie.trailer, testEntity.trailer)

        viewModel.getMovieDetailById().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTv() {
        val tvShow = MutableLiveData<MovieEntity>()
        tvShow.value = dummyTvShow

        `when`(moviesRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        val testEntity = viewModel.getTvShowDetailById().value as MovieEntity
        verify(moviesRepository).getDetailTvShow(tvShowId)

        assertNotNull(testEntity)
        assertEquals(dummyTvShow.id, testEntity.id)
        assertEquals(dummyTvShow.type, testEntity.type)
        assertEquals(dummyTvShow.title, testEntity.title)
        assertEquals(dummyTvShow.genre, testEntity.genre)
        assertEquals(dummyTvShow.poster, testEntity.poster)
        assertEquals(dummyTvShow.year, testEntity.year)
        assertEquals(dummyTvShow.rating, testEntity.rating, 0.01)
        assertEquals(dummyTvShow.description, testEntity.description)
        assertEquals(dummyTvShow.trailer, testEntity.trailer)

        viewModel.getTvShowDetailById().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}