package com.onirutla.submissiondicoding.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.data.model.TvEntity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private lateinit var movieEntity: MovieEntity
    private lateinit var tvEntity: TvEntity

    companion object {
        private const val movie_id = "movieId"
        private const val tv_id = "tvId"
        const val type_data = "type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvId = intent.getStringExtra(tv_id)
        val movieId = intent.getStringExtra(movie_id)
        val typeData = intent.getStringExtra(type_data)

        val viewModel = ViewModelProvider(
            this@DetailActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        if (typeData.equals("movie", true)) {
            movieId?.let {
                viewModel.setMovieId(it)
            }
            movieEntity = viewModel.getMovieDetailById()
            initMovieDetail()
        }
        if (typeData.equals("tv", true)) {
            tvId?.let {
                viewModel.setTvId(it)
            }
            tvEntity = viewModel.getTvDetailById()
            initTvDetail()
        }
    }

    private fun initTvDetail() {
        detail_title.text = tvEntity.title
        detail_description.text = tvEntity.description
        Glide.with(detail_image)
            .load(tvEntity.image)
            .error(R.drawable.ic_broken_image_black)
            .into(detail_image)
    }

    private fun initMovieDetail() {
        detail_title.text = movieEntity.title
        detail_description.text = movieEntity.description
        Glide.with(detail_image)
            .load(movieEntity.image)
            .error(R.drawable.ic_broken_image_black)
            .into(detail_image)
    }
}