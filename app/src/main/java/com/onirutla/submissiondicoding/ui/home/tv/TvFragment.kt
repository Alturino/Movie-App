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
    private val tvViewModel: TvViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tvAdapter = TvAdapter()
        activity?.let {
            tvViewModel.getTvShow().observe(viewLifecycleOwner, {
                tvAdapter.setTv(it)
                with(rv_tv) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvAdapter
                }
            })
        }
    }
}