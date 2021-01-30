package com.onirutla.submissiondicoding.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.source.repository.MovieRepository
import com.onirutla.submissiondicoding.utils.DataDummy
import com.onirutla.submissiondicoding.utils.vo.Resource
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
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(moviesRepository)
        viewModel.setMovieId(movieId)
        viewModel.setTvId(tvShowId)
    }

    @Test
    fun getDetailMovie() {
        val dummyDetailMovie = Resource.success(DataDummy.generateDummyMovie()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        `when`(moviesRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

    @Test
    fun getDetailTv() {
        val dummyDetailTvShow = Resource.success(DataDummy.generateDummyTv()[0])
        val tvShow = MutableLiveData<Resource<MovieEntity>>()
        tvShow.value = dummyDetailTvShow

        `when`(moviesRepository.getDetailTv(tvShowId)).thenReturn(tvShow)
        viewModel.tv.observeForever(observer)
        verify(observer).onChanged(dummyDetailTvShow)
    }
}
