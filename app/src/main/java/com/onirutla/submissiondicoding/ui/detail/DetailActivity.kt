package com.onirutla.submissiondicoding.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.utils.GlideApp
import com.onirutla.submissiondicoding.utils.vo.Status
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()


    companion object {
        const val movie_id = "movieId"
        const val tv_id = "tvId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.getStringExtra(tv_id)?.let { it ->
            viewModel.setTvId(it)
            viewModel.tv.observe(this, {
                when (it.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> it.data?.let { tvShow ->
                        progress_bar.visibility = View.GONE
                        populateView(tvShow)
                    }
                    Status.ERORR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(
                            applicationContext,
                            "Terjadi Kesalahan Saat Pengambilan Data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }

        intent.getStringExtra(movie_id)?.let { it ->
            viewModel.setMovieId(it)
            viewModel.movie.observe(this, {
                when (it.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> it.data?.let { movie ->
                        progress_bar.visibility = View.GONE
                        populateView(movie)
                    }
                    Status.ERORR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(
                            applicationContext,
                            "Terjadi Kesalahan Saat Pengambilan Data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }

        setContentView(R.layout.activity_detail)
    }

    private fun populateView(movie: MovieEntity) {
        detail_title.text = movie.title
        detail_description.text = movie.description
        GlideApp.with(detail_image)
            .load(movie.poster)
            .into(detail_image)

        var status = movie.is_favorite
        setStatusfavorite(status)

        fab_favorite.setOnClickListener {
            status = !status
            if(status){
                Toast.makeText(this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show()
            }
            setStatusfavorite(status)
            viewModel.setFavorite()

        }
    }

    private fun setStatusfavorite(status: Boolean) {
        if (status) {
            fab_favorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_24
                )
            )

        } else{
            fab_favorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border_24
                )
            )
        }
    }
}