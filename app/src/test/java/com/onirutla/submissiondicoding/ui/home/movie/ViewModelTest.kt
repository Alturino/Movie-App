package com.onirutla.submissiondicoding.ui.home.movie

import com.onirutla.submissiondicoding.ui.detail.DetailViewModel
import com.onirutla.submissiondicoding.ui.home.tv.TvViewModel
import com.onirutla.submissiondicoding.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ViewModelTest {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvViewModel: TvViewModel
    private lateinit var detailViewModel: DetailViewModel

    private val movie = DataDummy.generateDummyMovie()[0]
    private val tv = DataDummy.generateDummyTv()[0]

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
        tvViewModel = TvViewModel()
        detailViewModel = DetailViewModel()
    }

    @Test
    fun getMovies() {
        val movie = movieViewModel.getMovies()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }

    @Test
    fun getTv() {
        val tv = tvViewModel.getTvShow()
        assertNotNull(tv)
        assertEquals(10, tv.size)
    }

    @Test
    fun getDetailMovie() {
        val detailMovie = detailViewModel.getDetailMovie(movie.id)
        assertNotNull(detailMovie)
        assertEquals(movie.id, detailMovie?.id)
        assertEquals(movie.title, detailMovie?.title)
        assertEquals(movie.description, detailMovie?.description)
        assertEquals(movie.image, detailMovie?.image)
    }

    @Test
    fun getDetailTv() {
        val detailTv = detailViewModel.getDetailTv(tv.id)
        assertNotNull(detailTv)
        assertEquals(tv.id, detailTv?.id)
        assertEquals(tv.title, detailTv?.title)
        assertEquals(tv.description, detailTv?.description)
        assertEquals(tv.image, detailTv?.image)
    }
}