package com.onirutla.submissiondicoding.ui.favorite.tv

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
import com.onirutla.submissiondicoding.ui.detail.DetailActivity.Companion.tv_id
import com.onirutla.submissiondicoding.utils.GlideApp
import com.onirutla.submissiondicoding.utils.GlideOptions
import kotlinx.android.synthetic.main.items_tv.view.*

class FavoriteTvAdapter: PagedListAdapter<MovieEntity, FavoriteTvAdapter.FavoriteTvViewHolder>(DIFF_CALLBACK) {
    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvAdapter.FavoriteTvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv, parent, false)
        return FavoriteTvViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FavoriteTvAdapter.FavoriteTvViewHolder,
        position: Int
    ) {
        val tv = getItem(position)
        tv?.let {
            holder.bind(tv)
        }
    }

    inner class FavoriteTvViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tv: MovieEntity){
            with(itemView){
                tv_title.text = tv.title
                tv_description.text = tv.description
                GlideApp.with(context)
                    .load(tv.poster)
                    .apply(
                        GlideOptions.placeholderOf(R.drawable.ic_broken_image_black)
                            .error(R.drawable.ic_error)
                    ).into(tv_poster)
                setOnClickListener {
                    Intent(context, DetailActivity::class.java).apply {
                        putExtra(tv_id, tv.id)
                    }.run { context.startActivity(this) }
                }
            }
        }
    }
}
