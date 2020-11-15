package com.onirutla.submissiondicoding.ui.home.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.ui.detail.DetailActivity
import com.onirutla.submissiondicoding.utils.GlideApp
import com.onirutla.submissiondicoding.utils.GlideOptions.placeholderOf
import kotlinx.android.synthetic.main.items_tv.view.*

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var listTv = ArrayList<MovieEntity>()

    fun setTv(tv: List<MovieEntity>) {
        this.listTv.clear()
        this.listTv.addAll(tv)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv, parent, false)
        return TvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) =
        holder.bind(listTv[position])

    override fun getItemCount(): Int = listTv.size

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tv: MovieEntity) {
            with(itemView) {
                tv_title.text = tv.title
                tv_description.text = tv.description
                GlideApp.with(context)
                    .load(tv.poster)
                    .apply(
                        placeholderOf(R.drawable.ic_broken_image_black)
                            .error(R.drawable.ic_error)
                    ).into(tv_poster)
                setOnClickListener {
                    Intent(context, DetailActivity::class.java).apply {
                        putExtra("tvId", tv.id)
                    }.run { context.startActivity(this) }
                }
            }
        }
    }
}