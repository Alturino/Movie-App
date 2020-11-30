package com.onirutla.submissiondicoding.ui.favorite.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onirutla.submissiondicoding.R
import kotlinx.android.synthetic.main.fragment_favorite_tv.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteTvFragment : Fragment() {
    private val viewModel: FavoriteTvViewModel by viewModel()
    private lateinit var tvAdapter: FavoriteTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_tv, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvAdapter = FavoriteTvAdapter()

        viewModel.getFavoriteTvShow().observe(this, {
            tvAdapter.submitList(it)
            tvAdapter.notifyDataSetChanged()
            progress_bar.visibility = View.GONE
        })

        with(rv_favorite_tv){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvAdapter
        }
    }
}
