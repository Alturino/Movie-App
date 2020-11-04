package com.onirutla.submissiondicoding.ui.home.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.items_movie.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()

    fun setMovie(movie: List<MovieEntity>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                movie_title.text = movie.title
                movie_description.text = movie.description
                Glide.with(context)
                    .load(movie.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_broken_image_black)
                            .error(R.drawable.ic_error)
                    ).into(movie_poster)
                setOnClickListener {
                    Intent(context, DetailActivity::class.java).apply {
                        putExtra("movieId", movie.id)
                    }.run { context.startActivity(this) }
                }
            }
        }
    }
}