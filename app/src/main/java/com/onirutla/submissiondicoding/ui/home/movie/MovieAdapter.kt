package com.onirutla.submissiondicoding.ui.home.movie

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
import com.onirutla.submissiondicoding.utils.GlideOptions.placeholderOf
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieAdapter internal constructor(): PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(
    DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let {
            holder.bind(it)
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                movie_title.text = movie.title
                movie_description.text = movie.description
                GlideApp.with(context)
                    .load(movie.poster)
                    .apply(
                        placeholderOf(R.drawable.ic_broken_image_black)
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