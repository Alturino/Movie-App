package com.onirutla.submissiondicoding.ui.home.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onirutla.submissiondicoding.R
import kotlinx.android.synthetic.main.fragment_tv.*
import org.koin.android.viewmodel.ext.android.viewModel

class TvFragment : Fragment() {
    private val viewModel: TvViewModel by viewModel()
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvAdapter = TvAdapter()
        activity?.let {
            viewModel.getTvShow().observe(viewLifecycleOwner, {
                tvAdapter.submitList(it.data)
                with(rv_tv) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvAdapter
                }
            })
        }
    }
}