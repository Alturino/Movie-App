package com.onirutla.submissiondicoding.data.model

import androidx.annotation.DrawableRes

data class TvEntity(
    var title: String? = null,
    @DrawableRes var image : Int? = null,
    var description: String? = null
)