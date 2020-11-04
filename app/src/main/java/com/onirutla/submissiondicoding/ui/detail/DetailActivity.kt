package com.onirutla.submissiondicoding.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.onirutla.submissiondicoding.R
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    companion object {
        private const val movieId = "movieId"
        private const val tvId = "tvId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvId = intent.getStringExtra(tvId)
        val movieId = intent.getStringExtra(movieId)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        if(tvId != null) initTvDetail(tvId, viewModel)
        if(movieId != null) initMovieDetail(movieId, viewModel)
    }

    private fun initTvDetail(id: String?, viewModel: DetailViewModel) {
        val detailTv = viewModel.getDetailTv(id)
        detail_title.text = detailTv?.title
        detail_description.text = detailTv?.description
        Glide.with(detail_image)
            .load(detailTv?.image)
            .error(R.drawable.ic_broken_image_black)
            .into(detail_image)
    }

    private fun initMovieDetail(id: String?, viewModel: DetailViewModel) {
        val detailMovie = viewModel.getDetailMovie(id)
        detail_title.text = detailMovie?.title
        detail_description.text = detailMovie?.description
        Glide.with(detail_image)
            .load(detailMovie?.image)
            .error(R.drawable.ic_broken_image_black)
            .into(detail_image)
    }
}