package com.onirutla.submissiondicoding.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.utils.GlideApp
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()

    companion object {
        private const val movie_id = "movieId"
        private const val tv_id = "tvId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvId = intent.getStringExtra(tv_id)
        val movieId = intent.getStringExtra(movie_id)

        tvId?.let { initTvShow(tvId) }
        movieId?.let { initMovie(movieId) }
    }

    private fun initTvShow(tvId: String) {
        viewModel.setTvId(tvId)
        viewModel.getTvShowDetailById().observe(this, {
            detail_title.text = it.title
            detail_description.text = it.description
            GlideApp.with(detail_image)
                .load(it.poster)
                .error(R.drawable.ic_broken_image_black)
                .into(detail_image)
        })
    }

    private fun initMovie(movieId: String) {
        viewModel.setMovieId(movieId)
        viewModel.getMovieDetailById().observe(this, {
            detail_title.text = it.title
            detail_description.text = it.description
            GlideApp.with(detail_image)
                .load(it.poster)
                .error(R.drawable.ic_broken_image_black)
                .into(detail_image)
        })
    }
}