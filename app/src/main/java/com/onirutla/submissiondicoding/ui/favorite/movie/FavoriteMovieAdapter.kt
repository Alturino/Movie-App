package com.onirutla.submissiondicoding.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.ui.detail.DetailActivity
import com.onirutla.submissiondicoding.ui.detail.DetailActivity.Companion.movie_id
import com.onirutla.submissiondicoding.utils.GlideApp
import com.onirutla.submissiondicoding.utils.GlideOptions
import kotlinx.android.synthetic.main.items_movie.view.*

class FavoriteMovieAdapter :
    PagedListAdapter<MovieEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMovieAdapter.FavoriteMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return FavoriteMovieViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FavoriteMovieAdapter.FavoriteMovieViewHolder,
        position: Int
    ) {
        val movie = getItem(position)
        movie?.let {
            holder.bind(movie)
        }
    }

    inner class FavoriteMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                movie_title.text = movie.title
                movie_description.text = movie.description
                GlideApp.with(context)
                    .load(movie.poster)
                    .apply(
                        GlideOptions.placeholderOf(R.drawable.ic_broken_image_black)
                            .error(R.drawable.ic_error)
                    ).into(movie_poster)
                setOnClickListener {
                    Intent(context, DetailActivity::class.java).apply {
                        putExtra(movie_id, movie.id)
                    }.run { context.startActivity(this) }
                }
            }
        }
    }
}