package com.onirutla.submissiondicoding.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onirutla.submissiondicoding.R
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment() {
    private val viewModel: FavoriteMovieViewModel by viewModel()
    private lateinit var movieAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieAdapter = FavoriteMovieAdapter()
        viewModel.getFavoriteMovie().observe(this, {
            movieAdapter.submitList(it)
            movieAdapter.notifyDataSetChanged()
            progress_bar.visibility = View.GONE
        })

        with(rv_favorite_movie){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}