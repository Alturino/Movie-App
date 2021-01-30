package com.onirutla.submissiondicoding.ui.home.tv

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
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = TvViewModel(moviesRepository)
    }

    @Test
    fun getTv() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(5)
        val tvData = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        tvData.value = dummyTvShows

        `when`(moviesRepository.getAllTv()).thenReturn(tvData)
        val tvTest = viewModel.getTvShow().value?.data
        Mockito.verify(moviesRepository).getAllTv()
        assertNotNull(tvTest)
        assertEquals(5, tvTest?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}