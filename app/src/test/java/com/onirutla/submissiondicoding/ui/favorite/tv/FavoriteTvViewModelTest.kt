package com.onirutla.submissiondicoding.ui.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
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
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FavoriteTvViewModelTest {
    private lateinit var viewModel: FavoriteTvViewModel

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
        viewModel = FavoriteTvViewModel(movieRepository)
    }

    @Test
    fun getFavoriteTv(){
        val dummyFavoriteTv = pagedList
        `when`(dummyFavoriteTv.size).thenReturn(5)
        val favoriteTvData = MutableLiveData<PagedList<MovieEntity>>()
        favoriteTvData.value = dummyFavoriteTv

        `when`(movieRepository.getFavoriteTvShow()).thenReturn(favoriteTvData)
        val favoriteTvTest = viewModel.getFavoriteTvShow().value
        verify(movieRepository).getFavoriteTvShow()
        assertNotNull(favoriteTvTest)
        assertEquals(5, favoriteTvTest?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyFavoriteTv)
    }
}