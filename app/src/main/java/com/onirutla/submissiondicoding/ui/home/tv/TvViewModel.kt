package com.onirutla.submissiondicoding.ui.home.tv

import androidx.lifecycle.ViewModel
import com.onirutla.submissiondicoding.data.model.TvEntity
import com.onirutla.submissiondicoding.utils.DataDummy

class TvViewModel: ViewModel() {
    fun getTvShow(): List<TvEntity> = DataDummy.generateDummyTv()
}